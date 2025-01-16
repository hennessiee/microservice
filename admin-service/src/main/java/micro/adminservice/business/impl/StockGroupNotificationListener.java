package micro.adminservice.business.impl;

import micro.adminservice.business.UserService;
import micro.adminservice.domain.notification.StockGroupNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class StockGroupNotificationListener {

    private final UserService userService;

    public StockGroupNotificationListener(UserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = "stockGroupCreatedQueue")
    public void handleStockGroupCreatedNotification(StockGroupNotification notification) {
        Long stockGroupId = notification.getStockGroupId();

        userService.notifyUser(stockGroupId);
    }
}
