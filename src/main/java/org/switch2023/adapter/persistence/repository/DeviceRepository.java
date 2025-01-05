package org.switch2023.adapter.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.switch2023.adapter.persistence.entity.DeviceEntity;
import org.switch2023.adapter.persistence.mapper.DeviceMapper;
import org.switch2023.application.port.out.DomainDeviceRepository;
import org.switch2023.domain.device.Device;

@ApplicationScoped
@RequiredArgsConstructor
@Log4j2
public class DeviceRepository implements DomainDeviceRepository {

    private final PanacheRepositoryBase<DeviceEntity, Long> panacheRepository;

    private final DeviceMapper mapper;

    @Override
    public Device create(Device device) {
        final DeviceEntity deviceEntity = this.mapper.toEntity(device);
        this.panacheRepository.persistAndFlush(deviceEntity);
        log.info("Device created: '{}'.", deviceEntity.getId());
        return this.mapper.toModel(deviceEntity);
    }
}
