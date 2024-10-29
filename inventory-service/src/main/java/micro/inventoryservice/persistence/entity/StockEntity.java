package micro.inventoryservice.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import micro.inventoryservice.domain.stock.Stock;

@Entity
@Table(name="stock_entity")
@Getter
@Setter
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name="stock_group_id",nullable = true)
    private StockGroupEntity stockGroup;

    public Stock toDTO() {
        Stock stockDTO = new Stock();
        stockDTO.setId(this.id);
        stockDTO.setName(this.name);
        stockDTO.setDescription(this.description);
        stockDTO.setUnit(this.unit);
        stockDTO.setManufacturer(this.manufacturer);
        stockDTO.setSellingPrice(this.sellingPrice);
        stockDTO.setCostPrice(this.costPrice);
        stockDTO.setQuantity(this.quantity);
        stockDTO.setReorderPoint(this.reorderPoint);
        stockDTO.setType(this.type);
        return stockDTO;
    }
}
