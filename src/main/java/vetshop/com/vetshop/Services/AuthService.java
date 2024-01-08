package vetshop.com.vetshop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vetshop.com.vetshop.Repositories.IUserRepository;

public class AuthService implements UserDetailsService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return iUserRepository.findByLogin(username);
    }
}
