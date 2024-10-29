package micro.account.accountservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import micro.account.accountservice.business.RegisterUseCase;
import micro.account.accountservice.domain.register.RegisterRequest;
import micro.account.accountservice.domain.register.RegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:5173",allowedHeaders="*")
@RequestMapping("/auth")
public class RegisterController {
    private final RegisterUseCase registerUseCase;
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest registerRequest){
        RegisterResponse response =registerUseCase.register(registerRequest);

        return ResponseEntity.ok(response);
    }

}
