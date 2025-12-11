package collections.world_control_collections.controller;

import collections.world_control_collections.dto.web.CollectionWebDto;
import collections.world_control_collections.dto.web.ControlWebDto;
import collections.world_control_collections.facade.ControlCollectionsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    /**Pendiente: Traer info de forma ordenada ascendentemente*/
    @GetMapping("collections-detail")
    public List<ControlWebDto> findDetailCollections(@RequestParam(value = "collectionId") Long collectionId){
        return controlCollectionsFacade.findDetailCollections(collectionId);
    }

    @PostMapping("save/collections")
    public void saveCollections(@RequestBody CollectionWebDto collectionWebDto){
        controlCollectionsFacade.saveCollections(collectionWebDto);
    }

    @PostMapping("save/control-collections")
    public void saveControlCollections(@RequestBody List<ControlWebDto> controlWebDtoList){
        controlCollectionsFacade.saveControlCollections(controlWebDtoList);
    }
}
