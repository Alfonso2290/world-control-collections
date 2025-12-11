package collections.world_control_collections.service.impl;

import collections.world_control_collections.dto.CollectionDto;
import collections.world_control_collections.dto.ControlDto;
import collections.world_control_collections.entity.sql.Collection;
import collections.world_control_collections.entity.sql.Control;
import collections.world_control_collections.mapper.ControlCollectionsMapper;
import collections.world_control_collections.repository.sql.CollectionRepository;
import collections.world_control_collections.repository.sql.ControlRepository;
import collections.world_control_collections.service.ControlCollectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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
		List<ControlDto> controlNumeric = ControlCollectionsMapper.MAPPER.toControlListDto(controlRepository.findControlByNumerationNumeric(collectionId));
		List<ControlDto> controlAlphaNumeric = ControlCollectionsMapper.MAPPER.toControlListDto(controlRepository.findControlByNumerationAlphaNumeric(collectionId));

		List<ControlDto> responseControl=new ArrayList<>();
		responseControl.addAll(controlNumeric);
		responseControl.addAll(controlAlphaNumeric);

		return responseControl.stream().sorted(Comparator.comparing(ControlDto::getType)).collect(Collectors.toList());
	}

	@Override
	public void saveCollections(CollectionDto collectionDto) {
		collectionRepository.save(ControlCollectionsMapper.MAPPER.toCollection(collectionDto));
	}

	@Override
	public void saveControlCollections(List<ControlDto> controlDtoList) {
		Collection collectionEntity = collectionRepository.findById(controlDtoList.get(0).getCollectionId())
										.orElse(null);
		List<Control> controlEntities = ControlCollectionsMapper.MAPPER.toControlList(controlDtoList);
		controlEntities.forEach(control -> control.setCollection(collectionEntity));
		controlRepository.saveAll(controlEntities);
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
