package micro.account.accountservice.business;

import lombok.RequiredArgsConstructor;
import micro.account.accountservice.business.accesstoken.AccessTokenEncoder;
import micro.account.accountservice.business.exception.InvalidCredentialsException;
import micro.account.accountservice.domain.register.LoginRequest;
import micro.account.accountservice.domain.register.LoginResponse;
import micro.account.accountservice.domain.register.accesstoken.AccessToken;
import micro.account.accountservice.persistence.LoginRepository;
import micro.account.accountservice.persistence.entity.LoginEntity;
import micro.account.accountservice.persistence.entity.RoleEntity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final LoginRepository loginRepository;
    private final AccessTokenEncoder accessTokenEncoder;

    public LoginResponse login(LoginRequest loginRequest) {
        LoginEntity loginEntity = loginRepository.findByUsername(loginRequest.getUsername());
        if (loginEntity == null) {
            throw new InvalidCredentialsException();
        }

        String accessToken = generateAccessToken(loginEntity);
        return LoginResponse.builder().accessToken(accessToken).build();

    }

    private String generateAccessToken(LoginEntity loginEntity) {
        Long userId = loginEntity.getUser()!= null? loginEntity.getUser().getId() : null;
        List<String> roles = loginEntity.getRoles().stream()
                .map(RoleEntity::getName)
                .toList();

        return accessTokenEncoder.encode(
                AccessToken.builder()
                        .subject(loginEntity.getUsername())
                        .roles(roles)
                        .userId(userId)
                        .build());
    }
}

