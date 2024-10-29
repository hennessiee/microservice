package micro.account.accountservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import micro.account.accountservice.business.LoginUseCase;
import micro.account.accountservice.domain.register.LoginRequest;
import micro.account.accountservice.domain.register.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginUseCase loginUseCase;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse loginResponse = loginUseCase.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

}


