package micro.inventoryservice.domain.stockgroup;

import lombok.Data;
import micro.inventoryservice.domain.stock.Stock;
import micro.inventoryservice.persistence.entity.StockEntity;
import micro.inventoryservice.persistence.entity.StockGroupEntity;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetStockGroupByIdResponse {
    private Long id;
    private String name;
    private String description;
    private String unit;
    private List<Stock> stocks=new ArrayList<>();

    public GetStockGroupByIdResponse(StockGroupEntity stockEntity) {
        this.id = stockEntity.getId();
        this.name = stockEntity.getName();
        this.description = stockEntity.getDescription();
        this.unit = stockEntity.getUnit();

    }
}
