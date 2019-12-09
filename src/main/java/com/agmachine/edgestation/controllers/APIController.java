package com.agmachine.edgestation.controllers;

import com.agmachine.edgestation.models.EdgeStation;
import com.agmachine.edgestation.models.Machine;
import com.agmachine.edgestation.models.Sensor;
import com.agmachine.edgestation.services.EdgeStationService;
import com.agmachine.edgestation.services.MachineService;
import com.agmachine.edgestation.services.SensorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {
    private final EdgeStationService edgeStationService;
    private final MachineService machineService;
    private final SensorService sensorService;

    public APIController(EdgeStationService edgeStationService, MachineService machineService, SensorService sensorService) {
        this.edgeStationService = edgeStationService;
        this.machineService = machineService;
        this.sensorService = sensorService;
    }

    @GetMapping(value="/edgestation")
    public List<EdgeStation> findAllEdgeStation() {
        return edgeStationService.findAllEdgeStation();
    }

    @GetMapping(value="/machine")
    public List<Machine> findAllMachine() {
        return machineService.findAllMachine();
    }

    @GetMapping(value="/sensor")
    public List<Sensor> findAllSensor() {
        return sensorService.findAllSensor();
    }
}
