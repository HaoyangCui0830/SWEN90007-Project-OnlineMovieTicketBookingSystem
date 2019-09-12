DROP TABLE Customer;

CREATE TABLE Customer(
	customer_id INT GENERATED ALWAYS AS IDENTITY,
	firstname VARCHAR(100),
	lastname VARCHAR(100),
	PRIMARY KEY(customer_id)
);

