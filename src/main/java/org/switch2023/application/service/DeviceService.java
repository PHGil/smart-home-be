package org.switch2023.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.switch2023.application.port.in.DeviceUseCases;
import org.switch2023.application.port.out.DomainDeviceRepository;
import org.switch2023.domain.device.Device;

@RequiredArgsConstructor
@ApplicationScoped
public class DeviceService implements DeviceUseCases {

    private final DomainDeviceRepository repository;

    @Override
    public Device save(final Device device) {
        return this.repository.create(device);
    }

}
