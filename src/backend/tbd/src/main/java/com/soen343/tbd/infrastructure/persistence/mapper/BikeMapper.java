package com.soen343.tbd.infrastructure.persistence.mapper;

import com.soen343.tbd.domain.model.Bike;
import com.soen343.tbd.infrastructure.persistence.entity.BikeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BikeMapper {

    //Entity to Domain
    @Mapping(target = "bikeId", expression = "java(new BikeId(e.getBikeId()))")
    @Mapping(target = "dockId", expression = "java(null)")
    Bike toDomain(BikeEntity e);

    // Domain to Entity
    @Mapping(target = "bikeId", expression = "java(d.getBikeId() != null ? d.getBikeId().value() : null)")
    @Mapping(target = "dockId", expression = "java(null)")
    BikeEntity toEntity(Bike d);
}
