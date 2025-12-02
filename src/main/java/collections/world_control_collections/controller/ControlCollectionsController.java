package collections.world_control_collections.controller;

import collections.world_control_collections.dto.web.CollectionWebDto;
import collections.world_control_collections.facade.ControlCollectionsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/control/")
@RequiredArgsConstructor
public class ControlCollectionsController {

    private final ControlCollectionsFacade controlCollectionsFacade;

    @GetMapping("collections")
    public List<CollectionWebDto> findCollections(@RequestParam(value = "name", required = false) String nameCollection,
                                                  @RequestParam(value = "editorial", required = false) String editorial){
        return controlCollectionsFacade.findCollections(nameCollection, editorial);
    }
}
