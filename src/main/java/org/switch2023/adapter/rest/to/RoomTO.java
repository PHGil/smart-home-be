package org.switch2023.adapter.rest.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomTO {

    private Long id;

    private String name;

    private int floorNumber;

    private List<Long> dimensions;

    private boolean isInside;

    private List<DeviceTO> devices;
}
