package guru.sfg.beer.inventory.service.service;

import common.events.NewInventoryEvent;
import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewInventoryServiceListener {

    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void newInventoryListener(NewInventoryEvent newInventoryEvent){
        BeerInventory beerInventory = BeerInventory.builder()
                .Id(newInventoryEvent.getBeerDto().getId())
                .upc(newInventoryEvent.getBeerDto().getUpc())
                .quantityOnHand(newInventoryEvent.getBeerDto().getQuantityOnHand()).build();

        beerInventoryRepository.save(beerInventory);
    }
}
