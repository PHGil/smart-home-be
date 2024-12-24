package org.switch2023.adapter.rest.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomTO {

    private Long id;

    private String name;

    private Integer floorNumber;

    private Long length;

    private Long width;

    private Long height;

    private Boolean isInside;
}
