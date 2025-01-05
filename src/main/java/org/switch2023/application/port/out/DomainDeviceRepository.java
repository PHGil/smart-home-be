package org.switch2023.application.port.out;

import org.switch2023.domain.device.Device;

public interface DomainDeviceRepository {

    Device create(final Device device);
}
