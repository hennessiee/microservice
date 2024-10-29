package micro.account.accountservice.domain.register;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginResponse {
    String accessToken;
}
