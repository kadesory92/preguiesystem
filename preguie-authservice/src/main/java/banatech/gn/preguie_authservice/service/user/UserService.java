package banatech.gn.preguie_authservice.user;

import banatech.gn.preguie_authservice.request.LoginRequest;
import banatech.gn.preguie_authservice.request.RegisterRequest;
import banatech.gn.preguie_authservice.dto.UserDTO;
import banatech.gn.preguie_authservice.response.AuthResponse;

public interface UserService {
    UserDTO createUser(RegisterRequest request);
    UserDTO createAdmin(RegisterRequest request);
    AuthResponse authenticate(LoginRequest request);
}
