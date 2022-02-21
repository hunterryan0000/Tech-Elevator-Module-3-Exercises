BEGIN TRANSACTION;

DROP TABLE IF EXISTS purchase, customer, artwork, artist;

CREATE TABLE artist (
	id SERIAL,
	first_name VARCHAR(64) NOT NULL,
	last_name VARCHAR(64) NOT NULL,
	
	CONSTRAINT pk_artist_id PRIMARY KEY (id)
);

CREATE TABLE artwork (
	id SERIAL,
	title VARCHAR(100) NOT NULL,
	artist_id int NOT NULL,
	
	CONSTRAINT pk_artwork_id PRIMARY KEY (id),
	CONSTRAINT fk_artist_id FOREIGN KEY (artist_id) REFERENCES artist (id)
);

CREATE TABLE customer (
	id SERIAL,
	first_name VARCHAR(64) NOT NULL,
	last_name VARCHAR(64) NOT NULL,
	address VARCHAR(500),
	phone VARCHAR(15),
	
	CONSTRAINT pk_customer_id PRIMARY KEY (id)
);

CREATE TABLE purchase (
	id SERIAL,
	purchase_date TIMESTAMP NOT NULL,
	price MONEY NOT NULL,
	customer_id INT NOT NULL,
	artwork_id INT NOT NULL,
	
	CONSTRAINT pk_purchase_id PRIMARY KEY (id),
	CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id),
	CONSTRAINT fk_artwork_id FOREIGN KEY (artwork_id) REFERENCES artwork (id)
);

END TRANSACTION;