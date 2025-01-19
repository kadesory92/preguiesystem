package banatech.gn.preguie_authservice.service.user;

import banatech.gn.preguie_authservice.dto.UserDTO;
import banatech.gn.preguie_authservice.model.Role;
import banatech.gn.preguie_authservice.model.User;
import banatech.gn.preguie_authservice.repository.RoleRepository;
import banatech.gn.preguie_authservice.repository.UserRepository;
import banatech.gn.preguie_authservice.request.LoginRequest;
import banatech.gn.preguie_authservice.request.RegisterRequest;
import banatech.gn.preguie_authservice.response.AuthResponse;
import banatech.gn.preguie_authservice.security.model.AuthUser;
import banatech.gn.preguie_authservice.security.service.AuthUserService;
import banatech.gn.preguie_authservice.security.util.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final AuthUserService authUserService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository, UserMapper userMapper,
                           AuthenticationManager authenticationManager,
                           JwtUtils jwtUtils, AuthUserService authUserService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.authUserService = authUserService;
    }

    @Override
    public UserDTO createUser(RegisterRequest request) {
        return createUserWithRole(request, "ROLE_USER", "Default role automatically assigned to all users as soon as they register.");
    }

    @Override
    public UserDTO createAdmin(RegisterRequest request) {
        long nbAdmins = userRepository.countUsersByRoleName("ROLE_ADMIN");
        if (nbAdmins > 1) {
            throw new RuntimeException("There is already an ADMIN");
        }
        return createUserWithRole(request, "ROLE_ADMIN", "The role designating the administrator.");
    }

    private UserDTO createUserWithRole(RegisterRequest request, String roleName, String roleDescription) {
        if (userRepository.existsByUsername(request.getUsername())
                || userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User with this username " + request.getUsername() +
                    " or email " + request.getEmail() + " exists already");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>());
        }

        Role role = roleRepository.findByName(roleName).orElse(null);
        if (role == null) {
            role = new Role();
            role.setName(roleName);
            role.setDescription(roleDescription);
            roleRepository.save(role);
        }
        user.getRoles().add(role);
        return userMapper.convertToDTO(userRepository.save(user));
    }


//    @Override
//    public UserDTO createUser(RegisterRequest request) {
//        if (userRepository.existsByUsername(request.getUsername())
//                || userRepository.existsByEmail(request.getEmail())){
//            throw new RuntimeException("User with this username "+request.getUsername()+" " +
//                    "or email "+request.getEmail()+" exists already");
//        }
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setEmail(request.getEmail());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
//        if (user.getRoles() == null) {
//            user.setRoles(new HashSet<>());
//        }
//
//        Role defaultRole = roleRepository.findByName("ROLE_USER").orElse(null);
//        if (defaultRole == null){
//            defaultRole = new Role();
//            defaultRole.setName("ROLE_USER");
//            defaultRole.setDescription("Default role automatically assigned to all users as soon as they register.");
//            roleRepository.save(defaultRole);
//        }
//        user.getRoles().add(defaultRole);
//        return userMapper.convertToDTO(userRepository.save(user));
//    }
//
//    @Override
//    public UserDTO createAdmin(RegisterRequest request)
//    {
//        long nbAdmins = userRepository.countUsersByRoleName("ROLE_ADMIN");
//        if (nbAdmins > 1){
//            throw  new RuntimeException("There is already an ADMIN");
//        }
//
//        if (userRepository.existsByUsername(request.getUsername())
//                || userRepository.existsByEmail(request.getEmail())){
//            throw new RuntimeException("User with this username "+request.getUsername()+" " +
//                    "or email "+request.getEmail()+" exists already");
//        }
//
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setEmail(request.getEmail());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
//        if (user.getRoles() == null) {
//            user.setRoles(new HashSet<>());
//        }
//
//        Role defaultRole = roleRepository.findByName("ROLE_ADMIN").orElse(null);
//        if (defaultRole == null){
//            defaultRole = new Role();
//            defaultRole.setName("ROLE_ADMIN");
//            defaultRole.setDescription("The role designating the administrator.");
//            roleRepository.save(defaultRole);
//        }
//        user.getRoles().add(defaultRole);
//        return userMapper.convertToDTO(userRepository.save(user));
//    }

    @Override
    public AuthResponse authenticate(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
//        UserDetails userDetails = authUserService.loadUserByUsername(request.getUsername());
        AuthUser userDetails = (AuthUser) authentication.getPrincipal();
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUsername(userDetails.getUsername());
        Set<String> roleNames = userDetails.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        authResponse.setRoleNames(roleNames);
        authResponse.setToken(jwt);
        return authResponse;
    }
}
