create database storedb;

create user 'store_user'@'localhost' identified by 'store123';
grant all privileges on storedb.* to 'store_user'@'localhost';
flush privileges;

