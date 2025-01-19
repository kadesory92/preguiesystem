package banatech.gn.preguie_authservice.controller;

import banatech.gn.preguie_authservice.dto.UserDTO;
import banatech.gn.preguie_authservice.request.LoginRequest;
import banatech.gn.preguie_authservice.request.RegisterRequest;
import banatech.gn.preguie_authservice.response.AuthResponse;
import banatech.gn.preguie_authservice.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${server.prefix}/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody RegisterRequest request){
        try {
            UserDTO useSaved = userService.createUser(request);
            return ResponseEntity.ok(useSaved);
        }catch (RuntimeException e){
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/create-admin")
    public ResponseEntity<?> createAdmin(@RequestBody RegisterRequest request){
        try {
            UserDTO userSaved = userService.createAdmin(request);
            return ResponseEntity.ok(userSaved);
        } catch (RuntimeException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest request){
        try {
            AuthResponse authResponse = userService.authenticate(request);
            return ResponseEntity.ok(authResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
