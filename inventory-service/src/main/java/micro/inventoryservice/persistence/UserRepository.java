package micro.inventoryservice.persistence;

import micro.inventoryservice.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String username);
}

