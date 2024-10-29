package micro.inventoryservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import micro.inventoryservice.business.RegisterUseCase;
import micro.inventoryservice.domain.register.RegisterRequest;
import micro.inventoryservice.domain.register.RegisterResponse;
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
