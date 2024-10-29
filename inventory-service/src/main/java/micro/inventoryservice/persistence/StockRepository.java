package micro.inventoryservice.persistence;


import micro.inventoryservice.persistence.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StockEntity,Long> {
    List<StockEntity> findAllByStockGroup_Id(Long id);
}
