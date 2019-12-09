package com.agmachine.edgestation.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="sensor")
public class Sensor {
    @Id
    private String sensor_id;

    @Column(name="sensor_type")
    private String sensorType;

    @Column(name="sensor_status")
    private String sensorStatus;

    @Column(name="sensor_description")
    private String sensorDescription;

    @Column(name="edge_station_id")
    private String edgeStationId;

    @Column(name="machine_id")
    private String machineId;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;
}
