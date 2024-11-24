package org.switch2023.application.port.out;

import org.switch2023.domain.exception.NotFoundException;
import org.switch2023.domain.room.Room;

import java.util.List;

public interface DomainRoomRepository {

    List<Room> findAll();

    Room findById(final Long id) throws NotFoundException;

}
