package micro.inventoryservice.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import micro.inventoryservice.domain.stock.Stock;
import micro.inventoryservice.domain.stockgroup.StockGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="stock_group_entity")
@Getter
@Setter
public class StockGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String unit;
    @OneToMany(mappedBy = "stockGroup",cascade=CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<StockEntity> stocks=new ArrayList<>();
    // Conversion method to DTO
    public StockGroup toDTO() {
        StockGroup stockGroup = new StockGroup();
        stockGroup.setId(this.id);
        stockGroup.setName(this.name);
        stockGroup.setDescription(this.description);
        stockGroup.setUnit(this.unit);

        // Convert List<StockEntity> to List<StockDTO>
        List<Stock> stock = this.stocks.stream()
                .map(StockEntity::toDTO)
                .collect(Collectors.toList());
        stockGroup.setStocks(stock);
        return stockGroup;
        }
}
