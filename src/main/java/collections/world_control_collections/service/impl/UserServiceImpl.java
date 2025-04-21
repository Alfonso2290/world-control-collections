package collections.world_control_collections.service.impl;

import collections.world_control_collections.dto.UserResponseDto;
import collections.world_control_collections.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserResponseDto validateUser(String user, String password) {
        UserResponseDto response = new UserResponseDto();
        if(user.equals("Alfonso")){
            response.setMessage("Cuenta valida");
            response.setStatus("200");
        }else{
            response.setMessage("Cuenta invalida");
            response.setStatus("500");
        }
        return response;
    }
}
