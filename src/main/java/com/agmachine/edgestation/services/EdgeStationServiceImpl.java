package com.agmachine.edgestation.services;

import com.agmachine.edgestation.models.EdgeStation;
import com.agmachine.edgestation.repositories.EdgeStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeStationServiceImpl implements EdgeStationService{
    private final EdgeStationRepository edgeStationRepository;

    public EdgeStationServiceImpl(EdgeStationRepository edgeStationRepository) {
        this.edgeStationRepository = edgeStationRepository;
    }

    @Override
    public Long countRunningEdgeStation() {
        return edgeStationRepository.countByEdgeStationStatus("Running");
    }

    @Override
    public Long countAllEdgeStation() {
        return edgeStationRepository.countAllBy();
    }

    @Override
    public List <EdgeStation> findAllEdgeStation() {
        return edgeStationRepository.findAllBy();
    }

    @Override
    public EdgeStation changeEdgeStationStatus(String edgeStationId, String status) {
        EdgeStation edgeStation = edgeStationRepository.findById(edgeStationId).get();
        edgeStation.setEdgeStationStatus(status);
        return edgeStationRepository.save(edgeStation);
    }

    @Override
    public EdgeStation findById(String edgeStationId) {
        return edgeStationRepository.findById(edgeStationId).get();
    }

    @Override
    public EdgeStation update(EdgeStation edgeStation) {
        return edgeStationRepository.save(edgeStation);
    }
}
