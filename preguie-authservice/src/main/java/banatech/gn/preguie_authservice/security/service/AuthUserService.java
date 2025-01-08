package banatech.gn.preguie_authservice.security.service;

import banatech.gn.preguie_authservice.model.User;
import banatech.gn.preguie_authservice.repository.UserRepository;
import banatech.gn.preguie_authservice.security.model.AuthUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException("Not exists user with this username : "+username));
        return new AuthUser(user);
    }
}
