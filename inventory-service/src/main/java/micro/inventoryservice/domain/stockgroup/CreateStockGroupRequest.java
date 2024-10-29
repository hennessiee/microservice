package micro.inventoryservice.domain.stockgroup;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateStockGroupRequest {
    private String name;
    private String description;
    private String unit;

}

