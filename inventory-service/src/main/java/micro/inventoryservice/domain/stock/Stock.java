package micro.inventoryservice.domain.stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import micro.inventoryservice.persistence.entity.StockEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stock {
    private Long id;
    private String name;
    private String description;
    private String unit;
    private String manufacturer;
    private Double sellingPrice;
    private Double costPrice;
    private Integer quantity;
    private Integer reorderPoint;
    private String type;
    private Long stockGroupId;
    public Stock(StockEntity stockEntity) {
        this.id = stockEntity.getId();
        this.name = stockEntity.getName();
        this.description = stockEntity.getDescription();
        this.unit = stockEntity.getUnit();
        this.manufacturer = stockEntity.getManufacturer();
        this.sellingPrice = stockEntity.getSellingPrice();
        this.costPrice = stockEntity.getCostPrice();
        this.quantity = stockEntity.getQuantity();
        this.reorderPoint = stockEntity.getReorderPoint();
        this.type = stockEntity.getType();
    }

}
