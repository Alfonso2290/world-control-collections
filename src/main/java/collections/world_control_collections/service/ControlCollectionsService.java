package collections.world_control_collections.service;

import collections.world_control_collections.dto.CollectionDto;
import collections.world_control_collections.dto.ControlDto;

import java.util.List;

public interface ControlCollectionsService {

	List<CollectionDto> findCollections(String nameCollection, String editorial);

	List<ControlDto> findDetailCollections(Long collectionId);

	void saveCollections(CollectionDto collectionDto);

}
