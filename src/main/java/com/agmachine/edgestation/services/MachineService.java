package com.agmachine.edgestation.services;

import com.agmachine.edgestation.models.Machine;

import java.util.List;

public interface MachineService {
    Long countRunningMachine();
    Long countAllMachine();
    List<Machine> findAllMachine();
    Machine changeMachineStatus(String machineId, String status);
    Machine findById(String machineId);
    List<Machine> findByEdgeStationId(String edgeStationId);
    Machine update(Machine machine);
}
