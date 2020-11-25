package guru.sfg.brewery.common.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent  extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
