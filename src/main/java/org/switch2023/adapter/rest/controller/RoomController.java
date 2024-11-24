package org.switch2023.adapter.rest.controller;

import jakarta.enterprise.context.RequestScoped;
import lombok.RequiredArgsConstructor;
import org.switch2023.adapter.rest.mapper.RoomMapper;
import org.switch2023.adapter.rest.to.RoomTO;
import org.switch2023.application.port.in.RoomUseCases;
import org.switch2023.domain.exception.NotFoundException;

import java.util.List;

@RequestScoped
@RequiredArgsConstructor
public class RoomController implements RoomRouter {

    private final RoomUseCases service;

    private final RoomMapper mapper;

    public List<RoomTO> findRooms() {
        return this.mapper.toTO(this.service.findAll());
    }

    public RoomTO findRoomById(final Long id) throws NotFoundException {
        return this.mapper.toTO(this.service.findById(id));
    }
}
