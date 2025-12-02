package collections.world_control_collections.service.impl;

import collections.world_control_collections.dto.CollectionDto;
import collections.world_control_collections.entity.sql.Collection;
import collections.world_control_collections.mapper.ControlCollectionsMapper;
import collections.world_control_collections.repository.sql.CollectionRepository;
import collections.world_control_collections.service.ControlCollectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ControlCollectionsServiceImpl implements ControlCollectionsService {

	private final CollectionRepository collectionRepository;

	@Override
	public List<CollectionDto> findCollections(String nameCollection, String editorial) {
		return ControlCollectionsMapper.MAPPER.toCollectionListDto(filterSearch(nameCollection,editorial));
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
