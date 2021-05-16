create database Social_network;
use Social_network;
create table user
(	
	userId int primary key not null auto_increment,
    username varchar(45) unique,
	firstName varchar(45),
    lastName varchar(45),
    email varchar(45),
	password varchar(45)
);
create table post
(
	postId int primary key not null auto_increment,
    time datetime,
    content text,
    userId int,
    index (userId),
    foreign key (userId) references user(userId) on delete cascade on update cascade
)