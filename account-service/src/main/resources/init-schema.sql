DROP SCHEMA IF EXISTS account CASCADE;

CREATE SCHEMA account;


DROP TABLE IF EXISTS account.customer CASCADE;
DROP TABLE IF EXISTS account.accounts CASCADE;


DROP TABLE IF EXISTS account.customer;
DROP TABLE IF EXISTS account.accounts;

CREATE TABLE account.customer (
	customer_id bigint PRIMARY KEY NOT NULL  ,
	name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	mobile_number varchar(20) NOT NULL,
	create_dt date DEFAULT CURRENT_DATE
	);

CREATE TABLE account.accounts (
	customer_id  bigint NOT NULL references account.customer(customer_id),
	account_number BIGINT   PRIMARY KEY NOT NULL ,
	account_type varchar(100) NOT NULL,
	branch_address varchar(200) NOT NULL,
	create_dt date  DEFAULT CURRENT_DATE
	);
