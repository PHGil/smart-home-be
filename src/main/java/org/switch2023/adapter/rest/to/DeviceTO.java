package org.switch2023.adapter.rest.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceTO {

    private Long id;

    private String name;

    private String model;

    private boolean isActivate;
}
