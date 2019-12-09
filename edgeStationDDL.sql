DROP DATABASE IF EXISTS edge_station;
CREATE DATABASE edge_station;
USE edge_station;

CREATE TABLE edge_station_status (
    edge_station_status VARCHAR(20),
    status_description VARCHAR(200),
    PRIMARY KEY (edge_station_status)
);

CREATE TABLE machine_status (
    machine_status VARCHAR(20),
    machine_status_description VARCHAR(200),
    PRIMARY KEY (machine_status)
);

CREATE TABLE sensor_status (
    sensor_status VARCHAR(20),
    sensor_status_description VARCHAR(200),
    PRIMARY KEY (sensor_status)
);

CREATE TABLE machine_type (
    machine_type VARCHAR(20),
    machine_type_description VARCHAR(200),
    PRIMARY KEY (machine_type)
);

CREATE TABLE sensor_type (
    sensor_type VARCHAR(20),
    sensor_type_description VARCHAR(200),
    PRIMARY KEY (sensor_type)
);


CREATE TABLE edge_station (
    edge_station_id VARCHAR(5),
    edge_station_status VARCHAR(20),
    edge_station_description VARCHAR(200),
    latitude double,
    longitude double,
    PRIMARY KEY (edge_station_id)
);

CREATE TABLE machine (
    machine_id VARCHAR(5),
    machine_type VARCHAR(20),
    machine_status VARCHAR(20),
    machine_description VARCHAR(200),
    edge_station_id VARCHAR(5),
	latitude double,
    longitude double,
    PRIMARY KEY (machine_id)
);

CREATE TABLE sensor (
    sensor_id VARCHAR(5),
    sensor_type VARCHAR(20),
    sensor_status VARCHAR(20),
    sensor_description VARCHAR(200),
    edge_station_id VARCHAR(5),
    machine_id VARCHAR(5),
	latitude double,
    longitude double,
    PRIMARY KEY (sensor_id)
);

CREATE TABLE user (
    user_id VARCHAR(5),
    user_name VARCHAR(20),
    password varchar(32) NOT NULL,
    PRIMARY KEY (user_id)
);

INSERT INTO edge_station.user (user_id, user_name, password) VALUES ('00001', 'admin', '111111');
INSERT INTO edge_station.user (user_id, user_name, password) VALUES ('00002', 'xiaoning', '111111');

INSERT INTO edge_station.edge_station (edge_station_id, edge_station_status, edge_station_description, latitude, longitude) VALUES ('00001', 'Running', 'East1 123 test', 37.336237, -121.881209);
INSERT INTO edge_station.edge_station (edge_station_id, edge_station_status, edge_station_description, latitude, longitude) VALUES ('00002', 'Running', 'East2', 37.386237, -121.981209);
INSERT INTO edge_station.edge_station (edge_station_id, edge_station_status, edge_station_description, latitude, longitude) VALUES ('00003', 'Stop', 'South1', 37.123653, -121.763452);
INSERT INTO edge_station.edge_station (edge_station_id, edge_station_status, edge_station_description, latitude, longitude) VALUES ('00004', 'Stop', 'South', 37.981726, -121.787653);
INSERT INTO edge_station.edge_station (edge_station_id, edge_station_status, edge_station_description, latitude, longitude) VALUES ('00005', 'Maintaining', 'West1', 37.763849, -121.098653);

INSERT INTO edge_station.machine (machine_id, machine_type, machine_status, machine_description, edge_station_id, latitude, longitude) VALUES ('00001', 'Tractor', 'Running', 'Machine1', '00001', 37.367265, -121.389872);
INSERT INTO edge_station.machine (machine_id, machine_type, machine_status, machine_description, edge_station_id, latitude, longitude) VALUES ('00002', 'Drone', 'Running', 'Machine2', '00001', 37.267452, -121.387652);
INSERT INTO edge_station.machine (machine_id, machine_type, machine_status, machine_description, edge_station_id, latitude, longitude) VALUES ('00003', 'Tractor', 'Stop', 'M3', '00003', 37.387640, -121.098376);
INSERT INTO edge_station.machine (machine_id, machine_type, machine_status, machine_description, edge_station_id, latitude, longitude) VALUES ('00004', 'Drone', 'Running', 'M4', '00002', 37.340987, -121.237468);
INSERT INTO edge_station.machine (machine_id, machine_type, machine_status, machine_description, edge_station_id, latitude, longitude) VALUES ('00005', 'Truck', 'Stop', 'M3', '00003', 37.378710, -121.875483);
INSERT INTO edge_station.machine (machine_id, machine_type, machine_status, machine_description, edge_station_id, latitude, longitude) VALUES ('00006', 'Truck', 'Maintaining', 'M4', '00002', 37.672534, -121.986423);
INSERT INTO edge_station.machine (machine_id, machine_type, machine_status, machine_description, edge_station_id, latitude, longitude) VALUES ('00007', 'Drone', 'Running', 'M4', '00004', 37.536287, -121.893764);
INSERT INTO edge_station.machine (machine_id, machine_type, machine_status, machine_description, edge_station_id, latitude, longitude) VALUES ('00008', 'Truck', 'Stop', 'M3', '00005', 37.098362, -121.367485);

INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00001', 'SType1', 'Running', 'sensor1', null, '00001', 37.874865, -121.236501);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00002', 'SType1', 'Running', 'sensor2', '00004', null, 37.840981, -121.469287);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00003', 'SType2', 'Running', 'sensor3', null, '00002', 37.478264, -121.783651);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00004', 'SType1', 'Running', 'sensor4', null, '00001', 37.476565, -121.164537);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00005', 'SType1', 'Maintaining', 'sensor5', null, '00001', 37.476537, -121.987104);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00006', 'STypeABC', 'Running', 'sensor6', null, '00002', 37.209215, -121.019287);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00007', 'SType1', 'Running', 'sensor7', null, '00002', 37.290167, -121.478294);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00008', 'SType6', 'Running', 'sensor8', null, '00002', 37.475644, -121.098473);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00009', 'SType1', 'Stop', 'sensor9', null, '00003', 37.476527, -121.093746);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00010', 'SType1', 'Running', 'sensor10', null, '00004', 37.476528, -121.090989);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00011', 'SType7', 'Stop', 'sensor11', null, '00003', 37.112321, -121.4446372);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00012', 'SType1', 'Running', 'sensor12', null, '00002', 37.448982, -121.209876);
INSERT INTO edge_station.sensor (sensor_id, sensor_type, sensor_status, sensor_description, edge_station_id, machine_id, latitude, longitude) VALUES ('00013', 'SType4', 'Running', 'sensor13', null, '00003', 37.091273, -121.097384);


INSERT INTO edge_station.sensor_type (sensor_type, sensor_type_description) VALUES ('00001', 'Sensor Type1');
INSERT INTO edge_station.sensor_type (sensor_type, sensor_type_description) VALUES ('00002', 'Sensor Type2');
INSERT INTO edge_station.sensor_type (sensor_type, sensor_type_description) VALUES ('00003', 'Sensor Type3');
INSERT INTO edge_station.sensor_type (sensor_type, sensor_type_description) VALUES ('00004', 'Sensor Type4');

INSERT INTO edge_station.sensor_status (sensor_status, sensor_status_description) VALUES ('00000', 'Running');
INSERT INTO edge_station.sensor_status (sensor_status, sensor_status_description) VALUES ('99999', 'Stop');


INSERT INTO edge_station.machine_type (machine_type, machine_type_description) VALUES ('00001', 'machine1');
INSERT INTO edge_station.machine_type (machine_type, machine_type_description) VALUES ('00002', 'machine2');
INSERT INTO edge_station.machine_type (machine_type, machine_type_description) VALUES ('00003', 'machine3');

INSERT INTO edge_station.machine_status (machine_status, machine_status_description) VALUES ('00000', 'Running');
INSERT INTO edge_station.machine_status (machine_status, machine_status_description) VALUES ('99999', 'Stop');


INSERT INTO edge_station.edge_station_status (edge_station_status, status_description) VALUES ('00000', 'Running');
INSERT INTO edge_station.edge_station_status (edge_station_status, status_description) VALUES ('99999', 'Stop');