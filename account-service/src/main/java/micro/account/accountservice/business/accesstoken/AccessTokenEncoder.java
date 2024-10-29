package micro.account.accountservice.business.accesstoken;

import micro.account.accountservice.domain.register.accesstoken.AccessToken;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}

