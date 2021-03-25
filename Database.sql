create database Social_network;
create table user
(	
	userId int primary key not null auto_increment,
    username varchar(45),
	firstName varchar(45),
    lastName varchar(45),
    email varchar(45),
	password varchar(45)
);

INSERT INTO user (username,firstName,lastName,email,password) VALUES ('anhuynh','An','Huynh','anhuynh@gmail.com','01072000');