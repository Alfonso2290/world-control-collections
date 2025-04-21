package collections.world_control_collections.service;

import collections.world_control_collections.dto.UserResponseDto;

public interface UserService {
    UserResponseDto validateUser(String user, String password);
}
