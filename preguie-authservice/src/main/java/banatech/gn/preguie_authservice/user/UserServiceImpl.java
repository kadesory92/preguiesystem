package banatech.gn.preguie_authservice.user;

import banatech.gn.preguie_authservice.dto.UserDTO;
import banatech.gn.preguie_authservice.model.Role;
import banatech.gn.preguie_authservice.model.User;
import banatech.gn.preguie_authservice.repository.RoleRepository;
import banatech.gn.preguie_authservice.repository.UserRepository;
import banatech.gn.preguie_authservice.request.LoginRequest;
import banatech.gn.preguie_authservice.request.RegisterRequest;
import banatech.gn.preguie_authservice.response.AuthResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())
                || userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("User with this username "+request.getUsername()+" " +
                    "or email "+request.getEmail()+" exists already");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role defaultRole = roleRepository.findByName("ROLE_USER").orElse(null);
        if (defaultRole != null){
            user.getRoles().add(defaultRole);
        }else {
            defaultRole = new Role();
            defaultRole.setName("ROLE_USER");
            defaultRole.setDescription("Default role automatically assigned to all users as soon as they register.");
            Role roleSaved = roleRepository.save(defaultRole);
            user.getRoles().add(roleSaved);
        }
        return userMapper.convertToDTO(userRepository.save(user));
    }

    @Override
    public UserDTO createAdmin(RegisterRequest request) {
        return null;
    }

    @Override
    public AuthResponse authenticate(LoginRequest request) {
        return null;
    }
}
