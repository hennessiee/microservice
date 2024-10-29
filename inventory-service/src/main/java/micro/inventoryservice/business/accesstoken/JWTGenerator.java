package micro.inventoryservice.business.accesstoken;

import org.springframework.security.core.Authentication;

public interface JWTGenerator {
    String generateToken(Authentication authentication);
    String getUsernameFromJWT(String token);
    boolean validateToken(String token);

}


