package collections.world_control_collections.facade;

import collections.world_control_collections.dto.web.CollectionWebDto;
import collections.world_control_collections.dto.web.ControlWebDto;
import collections.world_control_collections.mapper.ControlCollectionsMapper;
import collections.world_control_collections.service.ControlCollectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ControlCollectionsFacade {

	private final ControlCollectionsService controlCollectionsService;

	public List<CollectionWebDto> findCollections(String nameCollection, String editorial){
		return ControlCollectionsMapper.MAPPER.toCollectionWebDto(controlCollectionsService.findCollections(nameCollection,editorial));
	}

	public List<ControlWebDto> findDetailCollections(Long collectionId){
		return ControlCollectionsMapper.MAPPER.toControlWebDto(controlCollectionsService.findDetailCollections(collectionId));
	}

}
