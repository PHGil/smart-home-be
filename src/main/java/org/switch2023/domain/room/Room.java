package org.switch2023.domain.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Long id;

    private String name;

    private int floorNumber;
    
    private List<Long> dimensions;

    private boolean isInside;

}
