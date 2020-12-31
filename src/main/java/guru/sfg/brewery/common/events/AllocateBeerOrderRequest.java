package guru.sfg.brewery.common.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllocateBeerOrderRequest {
    private BeerOrderDto beerOrderDto;
}
