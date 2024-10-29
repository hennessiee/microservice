package micro.facilityservice.persistence;

import micro.facilityservice.persistence.entity.FacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<FacilityEntity,Long> {
}
