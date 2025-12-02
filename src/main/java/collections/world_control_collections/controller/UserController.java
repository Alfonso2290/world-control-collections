package collections.world_control_collections.controller;

import collections.world_control_collections.dto.web.UserResponseWebDto;
import collections.world_control_collections.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;
    @GetMapping("validate/user")
    //@CrossOrigin(origins = "http://localhost:8080")
    public UserResponseWebDto validateUser(@RequestParam("user") String user, @RequestParam("password") String password){
        return userFacade.validateUser(user,password);
    }
}
