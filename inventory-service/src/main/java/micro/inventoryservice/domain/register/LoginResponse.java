package micro.inventoryservice.domain.register;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginResponse {
    String accessToken;
}
