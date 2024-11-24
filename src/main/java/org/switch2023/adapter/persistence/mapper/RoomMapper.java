package org.switch2023.adapter.persistence.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.switch2023.adapter.persistence.entity.DeviceEntity;
import org.switch2023.adapter.persistence.entity.RoomEntity;
import org.switch2023.domain.room.Room;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE, uses = {DeviceMapper.class})
public interface RoomMapper {

    Room toModel(RoomEntity entity);

    List<Room> toModel(List<RoomEntity> entities);

    @Mapping(target = "devices", qualifiedByName = "deviceToDeviceEntity")
    RoomEntity toEntity(Room room);

    List<RoomEntity> toEntity(List<Room> rooms);

    @Named("deviceToDeviceEntity")
    DeviceEntity deviceToDeviceEntity(DeviceEntity device);
}
