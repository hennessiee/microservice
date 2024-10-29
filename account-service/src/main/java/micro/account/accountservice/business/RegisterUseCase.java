package micro.account.accountservice.business;

import micro.account.accountservice.domain.register.RegisterRequest;
import micro.account.accountservice.domain.register.RegisterResponse;

public interface RegisterUseCase {
RegisterResponse register(RegisterRequest request);
}
