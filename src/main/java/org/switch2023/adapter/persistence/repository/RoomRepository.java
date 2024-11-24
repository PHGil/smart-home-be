package org.switch2023.adapter.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.switch2023.adapter.persistence.mapper.RoomMapper;
import org.switch2023.application.port.out.DomainRoomRepository;
import org.switch2023.domain.exception.NotFoundException;
import org.switch2023.domain.room.Room;

import java.util.List;


@ApplicationScoped
@RequiredArgsConstructor
@Log4j2
public class RoomRepository implements DomainRoomRepository {

    private final RoomPanacheRepository panacheRepository;

    private final RoomMapper mapper;

    @Override
    public Room findById(Long id) throws NotFoundException {
        return this.mapper.toModel(this.panacheRepository
                .findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(Room.class, id)));
    }

    @Override
    public List<Room> findAll() {
        return this.mapper.toModel(this.panacheRepository
                .findAll()
                .list());
    }
}
