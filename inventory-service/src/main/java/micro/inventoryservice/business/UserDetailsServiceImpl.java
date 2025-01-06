package micro.inventoryservice.business;

import micro.inventoryservice.domain.CustomUserDetails;
import micro.inventoryservice.persistence.LoginRepository;
import micro.inventoryservice.persistence.entity.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginEntity loginEntity = loginRepository.findByUsername(username);
        if (loginEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(loginEntity);
    }

}

