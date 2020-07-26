CREATE TABLE IF NOT EXISTS card(
id int NOT NULL AUTO_INCREMENT,
name varchar(255),
description varchar(255),
attack int,
defense int,
costid int,
PRIMARY KEY(id)
);