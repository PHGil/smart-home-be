package org.switch2023.domain.device;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String model;

    private boolean isActive;

}
