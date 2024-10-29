package micro.inventoryservice.business.accesstoken;

import micro.inventoryservice.domain.register.accesstoken.AccessToken;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}

