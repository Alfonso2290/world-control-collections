package collections.world_control_collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/control/")
public class ControlCollectionsController {

    @GetMapping("/message")
    public String getMessage(){
        return "El mensaje";
    }
}
