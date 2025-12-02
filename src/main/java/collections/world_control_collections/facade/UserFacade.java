package collections.world_control_collections.facade;

import collections.world_control_collections.dto.web.UserResponseWebDto;
import collections.world_control_collections.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    public UserResponseWebDto validateUser(String user, String password){
        return userService.validateUser(user, password);
    }
}
