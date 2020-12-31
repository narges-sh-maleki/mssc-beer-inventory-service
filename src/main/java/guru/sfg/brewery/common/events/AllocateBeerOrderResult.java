package guru.sfg.brewery.common.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllocateBeerOrderResult {
    private boolean allocationError;
    private boolean pendingInventory;
    private BeerOrderDto beerOrderDto;

}
