package com.agmachine.edgestation.repositories;

import com.agmachine.edgestation.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, String> {
    Long countAllBy();
    Long countBySensorStatus(String status);
    List<Sensor> findAllBy();
    List<Sensor> findByEdgeStationId(String edgeStationId);
    List<Sensor> findByMachineId(String machineId);
}
