package com.agmachine.edgestation.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(name="user_name")
    private String userName;
    private String password;
}
