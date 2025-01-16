package micro.adminservice.domain.notification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StockGroupNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long stockGroupId;

    private LocalDateTime createdAt;

    // Constructor, getters, and setters
    public StockGroupNotification(Long stockGroupId) {
        this.stockGroupId = stockGroupId;
        this.createdAt = LocalDateTime.now(); // Set current timestamp
    }

}

