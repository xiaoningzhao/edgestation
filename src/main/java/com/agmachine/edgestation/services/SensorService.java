package com.agmachine.edgestation.services;

import com.agmachine.edgestation.models.Sensor;

import java.util.List;

public interface SensorService {
    Long countRunningSensor();
    Long countAllSensor();
    List<Sensor> findAllSensor();
    Sensor changeSensorStatus(String sensorId, String status);
    Sensor findById(String sensorId);
    List<Sensor> findByEdgeStationId(String edgeStationId);
    List<Sensor> findByMachineId(String machineId);
    Sensor update(Sensor sensor);
}
