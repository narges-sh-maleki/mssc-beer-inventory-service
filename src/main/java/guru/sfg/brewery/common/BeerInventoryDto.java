package guru.sfg.brewery.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by jt on 2019-05-31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerInventoryDto {
    private UUID Id;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    //private UUID beerId;
    private Integer quantityOnHand;
}
