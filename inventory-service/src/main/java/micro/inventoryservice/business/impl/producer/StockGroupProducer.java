package micro.inventoryservice.business.impl.producer;

import lombok.RequiredArgsConstructor;
import micro.inventoryservice.domain.stockgroup.StockGroupNotification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockGroupProducer {

    private final RabbitTemplate rabbitTemplate;


    public void sendStockGroupCreatedNotification(Long stockGroupId) {
        StockGroupNotification notification = new StockGroupNotification(stockGroupId);
        rabbitTemplate.convertAndSend("stockGroupExchange", "stockGroupCreatedRoutingKey", notification);
    }
}
