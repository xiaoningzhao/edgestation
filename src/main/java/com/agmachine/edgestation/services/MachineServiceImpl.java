package com.agmachine.edgestation.services;

import com.agmachine.edgestation.models.Machine;
import com.agmachine.edgestation.repositories.MachineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineServiceImpl implements MachineService{
    private final MachineRepository machineRepository;

    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Long countRunningMachine() {
        return machineRepository.countByMachineStatus("Running");
    }

    @Override
    public Long countAllMachine() {
        return machineRepository.countAllBy();
    }

    @Override
    public List<Machine> findAllMachine() {
        return machineRepository.findAllBy();
    }

    @Override
    public Machine changeMachineStatus(String machineId, String status) {
        Machine machine = machineRepository.findById(machineId).get();
        machine.setMachineStatus(status);
        return machineRepository.save(machine);
    }

    @Override
    public Machine findById(String machineId) {
        return machineRepository.findById(machineId).get();
    }

    @Override
    public List<Machine> findByEdgeStationId(String edgeStationId) {
        return machineRepository.findByEdgeStationId(edgeStationId);
    }

    @Override
    public Machine update(Machine machine) {
        return machineRepository.save(machine);
    }
}
