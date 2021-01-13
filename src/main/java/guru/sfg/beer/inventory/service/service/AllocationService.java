package guru.sfg.beer.inventory.service.service;

import guru.sfg.brewery.common.events.BeerOrderDto;

import java.util.UUID;

public interface AllocationService {
    public Boolean allocateOrder(BeerOrderDto beerOrderDto);

    void deallocateOrder(UUID orderId);
}
