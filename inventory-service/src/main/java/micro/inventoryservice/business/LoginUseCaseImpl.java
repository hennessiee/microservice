package micro.inventoryservice.business;

import lombok.RequiredArgsConstructor;
import micro.inventoryservice.business.accesstoken.AccessTokenEncoder;
import micro.inventoryservice.business.exception.InvalidCredentialsException;
import micro.inventoryservice.domain.register.LoginRequest;
import micro.inventoryservice.domain.register.LoginResponse;
import micro.inventoryservice.domain.register.accesstoken.AccessToken;
import micro.inventoryservice.persistence.LoginRepository;
import micro.inventoryservice.persistence.entity.LoginEntity;
import micro.inventoryservice.persistence.entity.RoleEntity;

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

