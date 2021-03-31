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