package org.switch2023.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.switch2023.application.port.in.RoomUseCases;
import org.switch2023.application.port.out.DomainRoomRepository;
import org.switch2023.domain.exception.NotFoundException;
import org.switch2023.domain.room.Room;

import java.util.List;

@RequiredArgsConstructor
@ApplicationScoped
public class RoomService implements RoomUseCases {

    private final DomainRoomRepository repository;

    public List<Room> findAll() {
        return this.repository.findAll();
    }

    public Room findById(final Long id) throws NotFoundException {
        return this.repository.findById(id);
    }

    public Room save(final Room room) {
        return this.repository.create(room);
    }
}
