package micro.inventoryservice.domain.stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockDTO
{
    private Long id;
    private String name;
    private Integer quantity;
}
