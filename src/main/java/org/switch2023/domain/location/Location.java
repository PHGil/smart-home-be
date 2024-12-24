package org.switch2023.domain.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private Long id;

    private String address;

    private Long zipCode;

    private int coordinateX;

    private int coordinateY;
}
