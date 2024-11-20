package org.switch2023.adapter.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.switch2023.adapter.rest.to.RoomTO;
import org.switch2023.domain.room.Room;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface RoomMapper {

    RoomTO toTO(Room room);

    List<RoomTO> toTO(List<Room> rooms);
}
