package org.switch2023.domain.device;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String model;

    private boolean isActivate;

}
