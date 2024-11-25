package org.switch2023.domain.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.switch2023.domain.device.Device;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Long id;

    private String name;

    private Integer floorNumber;

    private Long length;

    private Long width;

    private Long height;

    private Boolean isInside;

    private List<Device> devices;
}
