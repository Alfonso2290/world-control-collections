package collections.world_control_collections.service;

import collections.world_control_collections.dto.web.UserResponseWebDto;

public interface UserService {
    UserResponseWebDto validateUser(String user, String password);
}
