package micro.inventoryservice.domain.stockgroup;

import lombok.Data;
import lombok.NoArgsConstructor;
import micro.inventoryservice.domain.stock.Stock;
import micro.inventoryservice.persistence.entity.StockGroupEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class StockGroup {
    private Long id;
    private String name;
    private String description;
    private String unit;
    private List<Stock> stocks=new ArrayList<>();
    public StockGroup(StockGroupEntity stockEntity) {
        this.id = stockEntity.getId();
        this.name = stockEntity.getName();
        this.description = stockEntity.getDescription();
        this.unit = stockEntity.getUnit();
        this.stocks=stockEntity.toDTO().getStocks();

    }

}
