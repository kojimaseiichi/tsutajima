-- drop database tsuta;
-- drop user tsuta@localhost;

-- create database tsuta;
-- create user 'tsuta'@localhost identified by 'tsuta';
-- grant all on tsuta.* to tsuta@localhost;

use tsuta;

-- 既存のテーブルを削除
drop table if exists 
	user,
	account,
	secret,
	role,
	user_role,
	resource,
	role_resource; 

-- ユーザー
create table user (
	id int primary key auto_increment,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	mail varchar(300),
	sex char(1)
);

-- アカウント
create table account (
	id int primary key auto_increment,
	secret_id int,
	display_name varchar(90) not null,
	disabled char(1) not null,
	constraint uq_account_display_name unique (display_name),
	constraint uq_secret_id unique (secret)
);

-- パスワード情報
create table secret (
	id int primary key auto_increment,
	secret varchar(1000) not null
);

-- ロール
create table role (
	id int primary key auto_increment,
	name varchar(30) not null,
	individual_account_id int,
	constraint uq_role_name unique (name)
);

-- [連関エンティティ]ユーザー ロール
create table user_role (
	user_id int,
	role_id int,
	constraint pk_user_role primary key (user_id, role_id)
	
);

-- リソース
create table resource (
	id int primary key auto_increment,
	subtype varchar(30) not null,
	uri varchar(1000) not null,
	express varchar(1000)
);

-- [連関エンティティ]ロール リソース
create table role_resource (
	role_id int,
	resource_id int,
	constraint pk_role_resource primary key (role_id, resource_id)
);

