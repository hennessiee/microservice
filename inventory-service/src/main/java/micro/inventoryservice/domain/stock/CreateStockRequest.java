package micro.inventoryservice.domain.stock;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import micro.inventoryservice.persistence.entity.StockGroupEntity;

@NoArgsConstructor
@Data
public class CreateStockRequest {
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
}
