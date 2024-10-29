package micro.inventoryservice.business.accesstoken;

import micro.inventoryservice.domain.register.accesstoken.AccessToken;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
