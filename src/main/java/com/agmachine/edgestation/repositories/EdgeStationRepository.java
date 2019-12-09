package com.agmachine.edgestation.repositories;

import com.agmachine.edgestation.models.EdgeStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdgeStationRepository extends JpaRepository<EdgeStation, String> {
    Long countAllBy();
    Long countByEdgeStationStatus(String status);
    List <EdgeStation> findAllBy();
}
