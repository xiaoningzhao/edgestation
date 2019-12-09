package com.agmachine.edgestation.services;

import com.agmachine.edgestation.models.EdgeStation;

import java.util.List;

public interface EdgeStationService {
    Long countRunningEdgeStation();
    Long countAllEdgeStation();
    List <EdgeStation> findAllEdgeStation();
    EdgeStation changeEdgeStationStatus(String edgeStationId, String status);
    EdgeStation findById(String edgeStationId);
    EdgeStation update(EdgeStation edgeStation);
}
