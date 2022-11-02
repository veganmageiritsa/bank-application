DROP SCHEMA IF EXISTS loan CASCADE;

CREATE SCHEMA loan;

DROP TABLE IF EXISTS loan.loans CASCADE;

CREATE TABLE loan.loans (
	loan_number BIGSERIAL NOT NULL PRIMARY KEY ,
	customer_id bigint NOT NULL,
	start_dt date NOT NULL,
	loan_type varchar(100) NOT NULL,
	total_loan bigint NOT NULL,
	amount_paid bigint NOT NULL,
	outstanding_amount bigint NOT NULL,
	create_dt date DEFAULT current_date
	);
