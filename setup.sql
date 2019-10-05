CREATE DATABASE WebService;
USE WebService;
CREATE TABLE FileStorage (
id INTEGER AUTO_INCREMENT,
checksum VARCHAR(32) NOT NULL,
path VARCHAR(250) DEFAULT NULL
PRIMARY KEY (id)
);
INSERT INTO FileStorage VALUES (1, '0a1b92ac25b7ea15f0bf5a72ee866ac4', 'C:\\Progra\\AWT04-WebService/temp/example.jpg';