package com.agmachine.edgestation.repositories;

import com.agmachine.edgestation.models.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MachineRepository extends JpaRepository<Machine, String> {
    Long countAllBy();
    Long countByMachineStatus(String status);
    List<Machine> findAllBy();
    List<Machine> findByEdgeStationId(String edgeStationId);
}
