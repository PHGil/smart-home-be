package org.switch2023.domain.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private Long id;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @Pattern(regexp = "^[A-Za-z0-9][A-Za-z0-9\\- ]{2,9}$")
    private Long zipCode;

    @Min(-180)
    @Max(180)
    private int coordinateX;

    @Min(-90)
    @Max(90)
    private int coordinateY;
}
