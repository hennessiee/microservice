package micro.adminservice.persistence;

import micro.adminservice.domain.notification.StockGroupNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockGroupNotificationRepository extends JpaRepository<StockGroupNotification, Long> {

}
