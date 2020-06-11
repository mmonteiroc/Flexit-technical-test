create database flexit;
use flexit;
create table employee(
    idEmployee bigint primary key auto_increment,
    name varchar(50), 
    last_event_date DATE);