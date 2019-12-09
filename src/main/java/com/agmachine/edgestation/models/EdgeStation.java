package com.agmachine.edgestation.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="edge_station")
public class EdgeStation {
    @Id
    private String edge_station_id;

    @Column(name="edge_station_status")
    private String edgeStationStatus;

    @Column(name="edge_station_description")
    private String edgeStationDescription;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

}
