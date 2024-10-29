package micro.inventoryservice.business;

import micro.inventoryservice.domain.register.RegisterRequest;
import micro.inventoryservice.domain.register.RegisterResponse;

public interface RegisterUseCase {
RegisterResponse register(RegisterRequest request);
}
