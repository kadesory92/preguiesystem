package banatech.gn.preguie_authservice.controller;

import banatech.gn.preguie_authservice.dto.UserDTO;
import banatech.gn.preguie_authservice.request.RegisterRequest;
import banatech.gn.preguie_authservice.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${server.port}/auth")
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
}
