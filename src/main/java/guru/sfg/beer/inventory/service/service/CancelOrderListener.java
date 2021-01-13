package guru.sfg.beer.inventory.service.service;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.brewery.common.events.CancelOrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CancelOrderListener {

    private final AllocationService allocationService;
    @JmsListener(destination = JmsConfig.CANCEL_ORDER)
    public void cancelOrderListen(CancelOrderRequest request){
        allocationService.deallocateOrder(request.getOrderId());
    }
}
