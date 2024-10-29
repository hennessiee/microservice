package micro.inventoryservice.domain.register;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RegisterRequest {
    private String username;
    private String password;
}

