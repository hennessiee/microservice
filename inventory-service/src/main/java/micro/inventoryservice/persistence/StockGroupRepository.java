package micro.inventoryservice.persistence;

import micro.inventoryservice.persistence.entity.StockEntity;
import micro.inventoryservice.persistence.entity.StockGroupEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockGroupRepository extends JpaRepository<StockGroupEntity,Long> {
    @Query("SELECT s FROM StockEntity s WHERE s.stockGroup.id = :id ORDER BY s.id ASC")
    List<StockEntity> findStocksByGroupId(@Param("id") Long id, Pageable pageable);

    Optional<StockGroupEntity> findById(Long id); // For fetching the StockGroupEntity
}
