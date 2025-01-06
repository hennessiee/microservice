package micro.inventoryservice.persistence;

import micro.inventoryservice.persistence.entity.StockGroupEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockGroupRepository extends JpaRepository<StockGroupEntity,Long> {
    @Query("SELECT sg FROM StockGroupEntity sg JOIN FETCH sg.stocks s WHERE sg.id = :id ORDER BY s.id ASC")
    StockGroupEntity findByIdWithLimitedStocks(@Param("id") Long id, Pageable pageable);
}
