package org.switch2023.adapter.rest.controller;

import jakarta.enterprise.context.RequestScoped;
import lombok.RequiredArgsConstructor;
import org.switch2023.adapter.rest.mapper.DeviceMapper;
import org.switch2023.adapter.rest.mapper.RoomMapper;
import org.switch2023.adapter.rest.to.DeviceTO;
import org.switch2023.adapter.rest.to.RoomTO;
import org.switch2023.application.port.in.RoomUseCases;
import org.switch2023.domain.exception.NotFoundException;

import java.util.List;

@RequestScoped
@RequiredArgsConstructor
public class RoomController implements RoomRouter {

    private final RoomUseCases service;

    private final RoomMapper roomMapper;

    private final DeviceMapper deviceMapper;


    @Override
    public RoomTO create(final RoomTO room) {
        return this.roomMapper.toTO(this.service.save(this.roomMapper.toDomain(room)));
    }

    @Override
    public List<RoomTO> findAll() {
        return this.roomMapper.toTO(this.service.findAll());
    }

    @Override
    public RoomTO findById(final Long id) throws NotFoundException {
        return this.roomMapper.toTO(this.service.findById(id));
    }

    @Override
    public List<DeviceTO> findDevices(final Long roomId) throws NotFoundException {
        return this.deviceMapper.toTO(this.service.findDevices(roomId));
    }
}
