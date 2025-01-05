package org.switch2023.adapter.rest.controller;

import jakarta.enterprise.context.RequestScoped;
import lombok.RequiredArgsConstructor;
import org.switch2023.adapter.rest.mapper.DeviceMapper;
import org.switch2023.adapter.rest.to.DeviceTO;
import org.switch2023.application.port.in.DeviceUseCases;

@RequestScoped
@RequiredArgsConstructor
public class DeviceController implements DeviceRouter {

    private final DeviceUseCases service;

    private final DeviceMapper mapper;

    @Override
    public DeviceTO create(final DeviceTO device) {
        return this.mapper.toTO(this.service.save(this.mapper.toDomain(device)));
    }
}
