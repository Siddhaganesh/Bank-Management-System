-- Create the database
CREATE DATABASE bankmanagementsystem;

-- Show all databases
SHOW DATABASES;

-- Select the database to use
USE bankmanagementsystem;
drop table  signuptwo;

show tables;
drop table signup;

-- Create the signup table
CREATE TABLE signup (
    formno VARCHAR(20),
    name VARCHAR(20),
    father_name VARCHAR(20),
    dob VARCHAR(20),
    gender VARCHAR(20),
    email VARCHAR(30),
    marital_status VARCHAR(20),
    address VARCHAR(40),
    city VARCHAR(25),
    pincode VARCHAR(20),
    state VARCHAR(20)
);

-- Show tables
SHOW TABLES;

-- Create the signuptwo table
CREATE TABLE signuptwo (
    formno VARCHAR(20),
    religion VARCHAR(50),
    category VARCHAR(50),
    income VARCHAR(50),
    education VARCHAR(50),
    occupation VARCHAR(50),
    pan VARCHAR(20),
    adhaar VARCHAR(20),
    seniorcitizen VARCHAR(10),
    existingaccount VARCHAR(10),
    PRIMARY KEY(formno)
);

select * from signupthree;
select * from login;

select * from bank;
drop table bank;
create table signupthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25), pin varchar(10), facility varchar(100));
create table login(formno varchar(20), cardnumber varchar(25), pin varchar(10));

create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20) );

SELECT * FROM bank WHERE pin = '1234';
