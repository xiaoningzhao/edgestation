package com.agmachine.edgestation.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="machine_status")
public class MachineStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String machine_status;

    @Column(name="machine_status_description")
    private String machineStatusDescription;
}
