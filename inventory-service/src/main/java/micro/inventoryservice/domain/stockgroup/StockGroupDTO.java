package micro.inventoryservice.domain.stockgroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import micro.inventoryservice.domain.stock.StockDTO;

import java.util.List;

@Data
@AllArgsConstructor
public class StockGroupDTO {
    private Long id;
    private String name;
    private String description;
    private List<StockDTO> stocks;

}
