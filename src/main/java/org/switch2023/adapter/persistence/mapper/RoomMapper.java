package org.switch2023.adapter.persistence.mapper;

import org.mapstruct.Builder;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.switch2023.adapter.persistence.entity.RoomEntity;
import org.switch2023.domain.room.Room;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
        builder = @Builder(disableBuilder = true),
        uses = {DeviceMapper.class})
public interface RoomMapper {

    Room toModel(RoomEntity entity);

    List<Room> toModel(List<RoomEntity> entities);

    @Mapping(target = "id", ignore = true)
    RoomEntity toEntity(Room room);

    List<RoomEntity> toEntity(List<Room> rooms);
}
