package collections.world_control_collections.service.impl;

import collections.world_control_collections.dto.CollectionDto;
import collections.world_control_collections.dto.ControlDto;
import collections.world_control_collections.entity.sql.Collection;
import collections.world_control_collections.mapper.ControlCollectionsMapper;
import collections.world_control_collections.repository.sql.CollectionRepository;
import collections.world_control_collections.repository.sql.ControlRepository;
import collections.world_control_collections.service.ControlCollectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ControlCollectionsServiceImpl implements ControlCollectionsService {

	private final CollectionRepository collectionRepository;
	private final ControlRepository controlRepository;

	@Override
	public List<CollectionDto> findCollections(String nameCollection, String editorial) {
		return ControlCollectionsMapper.MAPPER.toCollectionListDto(filterSearch(nameCollection,editorial));
	}

	@Override
	public List<ControlDto> findDetailCollections(Long collectionId) {
		Collection collectionEntity = collectionRepository.findById(collectionId).orElse(null);
		return ControlCollectionsMapper.MAPPER.toControlListDto(controlRepository.findByCollection(collectionEntity));
	}

	private  List<Collection> filterSearch(String nameCollection, String editorial){
		if(Objects.nonNull(nameCollection) && Objects.nonNull(editorial)){
			return collectionRepository.findByNameLikeAndEditorial("%" + nameCollection + "%", editorial);
		}

		if(Objects.nonNull(nameCollection)) return collectionRepository.findByNameLike("%" + nameCollection + "%");
		if(Objects.nonNull(editorial)) return collectionRepository.findByEditorial(editorial);

		return collectionRepository.findAll();
	}
}
