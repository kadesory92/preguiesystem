package banatech.gn.preguie_authservice.service.user;

import banatech.gn.preguie_authservice.dto.UserDTO;
import banatech.gn.preguie_authservice.model.Role;
import banatech.gn.preguie_authservice.model.User;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class UserMapper {
    UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoleNames(user.getRoles()
                .stream().map(Role::getName)
                .collect(Collectors.toSet()));
        return userDTO;
    }

    Set<UserDTO> convertToDTOS(Set<User> users){
        Set<UserDTO> userDTOS = new HashSet<>();
        for (User user: users){
            UserDTO userDTO = convertToDTO(user);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
}
