package com.agmachine.edgestation.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="edge_station_status")
public class EdgeStationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String edge_station_status;

    @Column(name="status_description")
    private String statusDescription;
}
