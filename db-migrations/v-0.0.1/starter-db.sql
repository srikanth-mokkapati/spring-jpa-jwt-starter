--Create DB
CREATE DATABASE testdb;

--Create User Table
CREATE TABLE users(
    username varchar(30) NOT NULL,
    password varchar(255) NOT NULL,
    PRIMARY KEY (username)
);

--create sample User with password as `password` (b6 Encoded)
USE testdb;
INSERT INTO users(username, password)
VALUES ('testUser', '$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq');

