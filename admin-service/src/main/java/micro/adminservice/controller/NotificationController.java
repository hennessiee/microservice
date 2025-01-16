package micro.adminservice.controller;

import lombok.RequiredArgsConstructor;
import micro.adminservice.domain.notification.StockGroupNotification;
import micro.adminservice.persistence.StockGroupNotificationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/logs")
public class NotificationController {

        private final StockGroupNotificationRepository notificationRepository;
        @GetMapping("/all")
        public List<StockGroupNotification> getAllNotifications() {
            return notificationRepository.findAll();
        }
}
