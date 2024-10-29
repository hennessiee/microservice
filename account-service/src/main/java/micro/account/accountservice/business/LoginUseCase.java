package micro.account.accountservice.business;

import micro.account.accountservice.domain.register.LoginRequest;
import micro.account.accountservice.domain.register.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest request);
}
