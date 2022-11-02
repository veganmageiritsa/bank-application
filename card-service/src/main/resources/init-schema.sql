DROP SCHEMA IF EXISTS card CASCADE;

CREATE SCHEMA card;

DROP TABLE IF EXISTS card.cards CASCADE;

CREATE TABLE card.cards (
	card_id BIGSERIAL NOT NULL PRIMARY KEY ,
	card_number varchar(100) NOT NULL,
	customer_id bigint NOT NULL,
	card_type varchar(100) NOT NULL,
	total_limit bigint NOT NULL,
	amount_used bigint NOT NULL,
	available_amount bigint NOT NULL,
	create_dt date DEFAULT NULL
	);
