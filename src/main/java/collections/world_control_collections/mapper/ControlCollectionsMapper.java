package collections.world_control_collections.mapper;

import collections.world_control_collections.dto.ControlDto;
import collections.world_control_collections.dto.web.ControlWebDto;
import collections.world_control_collections.entity.sql.Control;
import collections.world_control_collections.util.StatusType;
import collections.world_control_collections.dto.CollectionDto;
import collections.world_control_collections.dto.web.CollectionWebDto;
import collections.world_control_collections.entity.sql.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ControlCollectionsMapper {
	ControlCollectionsMapper MAPPER = Mappers.getMapper(ControlCollectionsMapper.class);

	List<CollectionWebDto> toCollectionWebDto(List<CollectionDto> collectionDto);

	List<CollectionDto> toCollectionListDto(List<Collection> collections);

	@Mapping(target = "status", source = "status",qualifiedByName = "getStatus")
	CollectionDto toCollectionDto(Collection collection);

	@Named("getStatus")
	default String getStatus(String status){
		return StatusType.valueOf(status).description;
	}

	List<ControlWebDto> toControlWebDto(List<ControlDto> controlDtoList);

	List<ControlDto> toControlListDto(List<Control> controlList);

	@Mapping(target = "status", source = "status", qualifiedByName = "mappingStatus")
	@Mapping(target = "binder", source = "binder", qualifiedByName = "mappingBinder")
	CollectionDto getCollectionDto(CollectionWebDto collectionWebDto);

	@Named("mappingStatus")
	default String mappingStatus(String status){
		return StatusType.getValueFromDescription(status).name();
	}

	@Named("mappingBinder")
	default String mappingBinder(String binder){
		return "Si".equals(binder)? "S" : "N";
	}

	Collection toCollection(CollectionDto collectionDto);

	List<ControlDto> toControlDtoList(List<ControlWebDto> controlWebDtoList);

	List<Control> toControlList(List<ControlDto> controlDtoList);
}
