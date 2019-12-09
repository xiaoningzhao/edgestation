package com.agmachine.edgestation.services;

import com.agmachine.edgestation.models.Machine;
import com.agmachine.edgestation.models.Sensor;
import com.agmachine.edgestation.repositories.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService{
    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Long countRunningSensor() {
        return sensorRepository.countBySensorStatus("Running");
    }

    @Override
    public Long countAllSensor() {
        return sensorRepository.countAllBy();
    }

    @Override
    public List<Sensor> findAllSensor() {
        return sensorRepository.findAllBy();
    }

    @Override
    public Sensor changeSensorStatus(String sensorId, String status) {
        Sensor sensor = sensorRepository.findById(sensorId).get();
        sensor.setSensorStatus(status);
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor findById(String sensorId) {
        return sensorRepository.findById(sensorId).get();
    }

    @Override
    public List<Sensor> findByEdgeStationId(String edgeStationId) {
        return sensorRepository.findByEdgeStationId(edgeStationId);
    }

    @Override
    public List<Sensor> findByMachineId(String machineId) {
        return sensorRepository.findByMachineId(machineId);
    }

    @Override
    public Sensor update(Sensor sensor) {
        return sensorRepository.save(sensor);
    }
}
