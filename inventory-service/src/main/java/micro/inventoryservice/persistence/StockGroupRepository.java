package micro.inventoryservice.persistence;

import micro.inventoryservice.persistence.entity.StockGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockGroupRepository extends JpaRepository<StockGroupEntity,Long> {
}
