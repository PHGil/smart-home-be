package org.switch2023.domain.house;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.switch2023.domain.room.Room;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class House {

    private Long id;

    private List<Room> rooms;
}
