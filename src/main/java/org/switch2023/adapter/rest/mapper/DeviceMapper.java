package org.switch2023.adapter.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.switch2023.adapter.rest.to.DeviceTO;
import org.switch2023.domain.device.Device;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface DeviceMapper {

    DeviceTO toTO(Device device);

    List<DeviceTO> toTO(List<Device> devices);

    Device toDomain(DeviceTO device);

    List<Device> toDomain(List<DeviceTO> devices);
}
