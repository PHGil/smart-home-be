package org.switch2023.adapter.persistence.mapper;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.switch2023.adapter.persistence.entity.DeviceEntity;
import org.switch2023.domain.device.Device;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface DeviceMapper {

    Device toModel(DeviceEntity entity);

    List<Device> toModel(List<DeviceEntity> entities);

    DeviceEntity toEntity(Device device);

    List<DeviceEntity> toEntity(List<Device> devices);
}
