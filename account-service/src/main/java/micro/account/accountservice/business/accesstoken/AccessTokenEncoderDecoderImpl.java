package micro.account.accountservice.business.accesstoken;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import micro.account.accountservice.configuration.security.auth.SecurityConstants;
import micro.account.accountservice.domain.register.accesstoken.AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccessTokenEncoderDecoderImpl implements AccessTokenEncoder, AccessTokenDecoder, JWTGenerator {
    private final SecretKey key;

    public AccessTokenEncoderDecoderImpl(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String encode(AccessToken accessToken) {
        Map<String, Object> claimsMap = new HashMap<>();

        if (!CollectionUtils.isEmpty(accessToken.getRoles())) {
            claimsMap.put("roles", accessToken.getRoles());
        }
        if (accessToken.getUserId() != null) {
            claimsMap.put("userId", accessToken.getUserId());
        }
        Instant now = Instant.now();

        var jwtBuilder = Jwts.builder()
                .claim(Claims.SUBJECT, accessToken.getSubject())
                .claim(Claims.ISSUED_AT, Date.from(now))
                .claim(Claims.EXPIRATION, Date.from(now.plus(30, ChronoUnit.MINUTES)));


        claimsMap.forEach(jwtBuilder::claim);

        return jwtBuilder.signWith(key).compact();

    }

    public AccessToken decode(String accessTokenEncoded) {
        try {
            Jwt<JwsHeader, Claims> jwt = Jwts.parser().verifyWith(key).build().parseSignedClaims(accessTokenEncoded);

            Claims claims =  jwt.getPayload();

            @SuppressWarnings("unchecked")
            List<String> roles = claims.get("roles", List.class);

            return AccessToken.builder()
                    .subject(claims.getSubject())
                    .roles(roles)
                    .userId(claims.get("userId", Long.class))
                    .build();
        }
        catch (JwtException e) {
            return null;
        }
    }
    public String generateToken(Authentication authentication){
        String username=authentication.getName();
        Date currentDate=new Date();
        Date expiryDate=new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

        return Jwts.builder()
                .claim(Claims.SUBJECT, username)
                .claim(Claims.ISSUED_AT, currentDate) // Using Claims.ISSUED_AT to set the issue time
                .claim(Claims.EXPIRATION, expiryDate)
                .signWith(key)
                .compact();
    }
    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();


        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return true;
        }catch(Exception exc){
            throw new AuthenticationCredentialsNotFoundException("JWT is incorrect");
        }
    }
}

