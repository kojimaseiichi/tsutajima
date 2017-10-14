create database tsuta;
create user tsutap@localhost identified by tsutap;
grant all on tsuta.* to tsutap@localhost;

create table user (
	id int primary key auto_increment,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	mail varchar(300),
	account_id int
);

create table role (
	id int primary key auto_increment,
	name varchar(30) not null
);

create table account (
	id int primary key auto_increment,
	user_name varchar(90) not null,
	password varchar(90) not null,
	locked boolean not null,
	constraint account_uq_user_name unique (user_name)
);

-- 
create table user_role (
	user_id int not null,
	role_id int not null,
	constraint user_role_pk primary key (user_id, role_id),
	constraint user_role_fk1 foreign key (user_id) references user(id) on update no action on delete no action,
	constraint user_role_fk2 foreign key (role_id) references role(id) on update no action on delete no action
	
);
