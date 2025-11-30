package collections.world_control_collections.service.impl;

import collections.world_control_collections.dto.UserResponseDto;
import collections.world_control_collections.entity.sql.User;
import collections.world_control_collections.repository.sql.UserRepository;
import collections.world_control_collections.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto validateUser(String user, String password) {
        User userEntity = userRepository.findByUsernameAndPassword(user, password);

        UserResponseDto response = new UserResponseDto();
        if(userEntity != null){
            response.setMessage("Cuenta valida");
            response.setStatus("200");

        }else{
            response.setMessage("Cuenta invalida");
            response.setStatus("500");
        }
        return response;
    }
}
