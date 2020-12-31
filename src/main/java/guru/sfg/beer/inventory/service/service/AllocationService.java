package guru.sfg.beer.inventory.service.service;

import guru.sfg.brewery.common.events.BeerOrderDto;

public interface AllocationService {
    public Boolean allocateOrder(BeerOrderDto beerOrderDto);
}
