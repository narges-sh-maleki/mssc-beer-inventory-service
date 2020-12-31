package guru.sfg.beer.inventory.service.service;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import guru.sfg.brewery.common.events.AllocateBeerOrderRequest;
import guru.sfg.brewery.common.events.AllocateBeerOrderResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class AllocateOrderListener {

    private  final BeerInventoryRepository beerInventoryRepository;
    private final JmsTemplate jmsTemplate;
    private final AllocationService allocationService;

    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER)
    public void allocateOrderListen(AllocateBeerOrderRequest allocateBeerOrderRequest){


        AllocateBeerOrderResult.AllocateBeerOrderResultBuilder builder = AllocateBeerOrderResult.builder();
        builder.beerOrderDto(allocateBeerOrderRequest.getBeerOrderDto());
        try {
            Boolean result = allocationService.allocateOrder(allocateBeerOrderRequest.getBeerOrderDto());
            if (result)
                builder.pendingInventory(false);
            else
                builder.pendingInventory(true);

            builder.allocationError(false);

        }
        catch (Exception e){
            log.error("allocation failed for orderId" + allocateBeerOrderRequest.getBeerOrderDto().getId());
            builder.allocationError(true);
        }


        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESULT,builder.build());


    }
}
