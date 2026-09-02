package collections.world_control_collections.service.impl;

import collections.world_control_collections.dto.web.UserResponseWebDto;
import collections.world_control_collections.entity.sql.User;
import collections.world_control_collections.repository.sql.UserRepository;
import collections.world_control_collections.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseWebDto validateUser(String user, String password) {
        User userEntity = userRepository.findByUsernameAndPassword(user, password);

        UserResponseWebDto response = new UserResponseWebDto();
        if(userEntity != null){
            response.setMessage("Login exitoso");
            response.setStatus("200");

        }else{
            response.setMessage("Usuario y/o Contraseña erronea");
            response.setStatus("404");
        }
        return response;
    }

    @Override
    @Transactional
    public Boolean saveUser(String user, String password) {
        User validateUserName = userRepository.findByUsername(user);

        if(Objects.nonNull(validateUserName) && validateUserName.getUsername().equals(user)){
            return Boolean.FALSE;
        }

        User userEntity = new User();
        userEntity.setUsername(user);
        userEntity.setPassword(password);
        userRepository.save(userEntity);

        return Boolean.TRUE;
    }
}
