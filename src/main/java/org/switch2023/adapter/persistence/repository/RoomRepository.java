package org.switch2023.adapter.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.switch2023.adapter.persistence.entity.RoomEntity;
import org.switch2023.adapter.persistence.mapper.RoomMapper;
import org.switch2023.application.port.out.DomainRoomRepository;
import org.switch2023.domain.exception.NotFoundException;
import org.switch2023.domain.room.Room;

import java.util.List;


@ApplicationScoped
@RequiredArgsConstructor
@Log4j2
public class RoomRepository implements DomainRoomRepository {

    private final PanacheRepositoryBase<RoomEntity, Long> panacheRepository;

    private final RoomMapper mapper;

    @Override
    public Room findById(final Long id) throws NotFoundException {
        return this.mapper.toModel(this.panacheRepository
                .findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException(Room.class, id)));
    }

    @Override
    @Transactional
    public Room create(final Room room) {
        final RoomEntity roomEntity = this.mapper.toEntity(room);
        this.panacheRepository.persistAndFlush(roomEntity);
        log.info("Room created: '{}'.", roomEntity.getId());
        return this.mapper.toModel(roomEntity);
    }

    @Override
    public List<Room> findAll() {
        return this.mapper.toModel(this.panacheRepository
                .findAll()
                .list());
    }
}
