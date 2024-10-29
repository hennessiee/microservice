package micro.inventoryservice.persistence;

import micro.inventoryservice.persistence.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("loginRepository")
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {
    LoginEntity findByUsername(String username);
    Boolean existsByUsername(String username);
}

