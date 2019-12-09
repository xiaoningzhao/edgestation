package com.agmachine.edgestation.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="machine")
public class Machine {
    @Id
    private String machine_id;

    @Column(name="machine_type")
    private String machineType;

    @Column(name="machine_status")
    private String machineStatus;

    @Column(name="machine_description")
    private String machineDescription;

    @Column(name="edge_station_id")
    private String edgeStationId;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

}
