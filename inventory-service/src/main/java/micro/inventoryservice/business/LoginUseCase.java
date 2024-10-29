package micro.inventoryservice.business;

import micro.inventoryservice.domain.register.LoginRequest;
import micro.inventoryservice.domain.register.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest request);
}
