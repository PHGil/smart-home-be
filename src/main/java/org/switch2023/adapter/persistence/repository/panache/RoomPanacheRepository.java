package org.switch2023.adapter.persistence.repository.panache;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.switch2023.adapter.persistence.entity.RoomEntity;

@ApplicationScoped
public class RoomPanacheRepository implements PanacheRepositoryBase<RoomEntity, Long> {}
