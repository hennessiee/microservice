package micro.adminservice.business.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import micro.adminservice.business.UserService;
import micro.adminservice.domain.notification.StockGroupNotification;
import micro.adminservice.persistence.StockGroupNotificationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final StockGroupNotificationRepository repository;
    public void notifyUser(Long stockGroupId) {
        StockGroupNotification notification = new StockGroupNotification(stockGroupId);
        repository.save(notification);
        System.out.println("User has been notified about Stock Group with ID: " + stockGroupId);
    }
}
