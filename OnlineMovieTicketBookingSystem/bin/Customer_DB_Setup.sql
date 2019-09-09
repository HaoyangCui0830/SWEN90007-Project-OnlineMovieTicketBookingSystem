DROP TABLE Customer;

CREATE TABLE Customer(
	customer_id INT,
	firstname VARCHAR(100),
	lastname VARCHAR(100),
	PRIMARY KEY(customer_id)
);

INSERT INTO Customer VALUES (100, 'Haoyang', 'Cui')