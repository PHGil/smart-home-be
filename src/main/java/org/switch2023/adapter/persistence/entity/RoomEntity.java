package org.switch2023.adapter.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "room")
public class RoomEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "floor_number")
    private int floorNumber;

    @Column(name = "length")
    private Long length;

    @Column(name = "width")
    private Long width;

    @Column(name = "height")
    private Long height;

    @Column(name = "is_inside")
    private boolean isInside;

    @OneToMany(mappedBy = "room", cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @ToString.Exclude
    @Builder.Default
    private List<DeviceEntity> devices = new ArrayList<>();
}
