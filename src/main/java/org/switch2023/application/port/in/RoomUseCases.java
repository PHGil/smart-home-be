package org.switch2023.application.port.in;


import org.switch2023.domain.exception.NotFoundException;
import org.switch2023.domain.room.Room;

import java.util.List;

public interface RoomUseCases {

    List<Room> findAll();

    Room findById(final Long id) throws NotFoundException;

}
