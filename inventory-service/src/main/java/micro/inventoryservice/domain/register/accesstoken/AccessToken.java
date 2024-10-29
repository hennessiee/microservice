package micro.inventoryservice.domain.register.accesstoken;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AccessToken {
    private String subject;
    private List<String> roles;
    private Long userId;

}

