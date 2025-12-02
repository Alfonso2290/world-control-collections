package collections.world_control_collections.mapper;

import collections.world_control_collections.dto.CollectionDto;
import collections.world_control_collections.dto.web.CollectionWebDto;
import collections.world_control_collections.entity.sql.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ControlCollectionsMapper {
	ControlCollectionsMapper MAPPER = Mappers.getMapper(ControlCollectionsMapper.class);

	List<CollectionWebDto> toCollectionWebDto(List<CollectionDto> collectionDto);

	List<CollectionDto> toCollectionDto(List<Collection> collections);
}
