package micro.account.accountservice.business;

import lombok.RequiredArgsConstructor;
import micro.account.accountservice.domain.register.RegisterRequest;
import micro.account.accountservice.domain.register.RegisterResponse;
import micro.account.accountservice.persistence.LoginRepository;
import micro.account.accountservice.persistence.RoleRepository;
import micro.account.accountservice.persistence.UserRepository;
import micro.account.accountservice.persistence.entity.LoginEntity;
import micro.account.accountservice.persistence.entity.RoleEntity;
import micro.account.accountservice.persistence.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RegisterUseCaseImpl implements RegisterUseCase {
    private final LoginRepository loginRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    public RegisterResponse register(RegisterRequest request) {

        Boolean existsByUsername= loginRepository.existsByUsername(request.getUsername());
        if (Boolean.TRUE.equals(existsByUsername)) {
            return new RegisterResponse("Username is taken!");
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(request.getUsername());
            UserEntity savedUser = userRepository.save(userEntity);

            LoginEntity loginEntity = new LoginEntity();
            loginEntity.setUsername(request.getUsername());
            loginEntity.setPassword(passwordEncoder.encode(request.getPassword()));

            RoleEntity roles = roleRepository.findByName("CUSTOMER");
            loginEntity.setRoles(Collections.singleton(roles));

            loginEntity.setUser(savedUser);

            loginRepository.save(loginEntity);

            return new RegisterResponse("user Registration Success!");
        }
    }
}


