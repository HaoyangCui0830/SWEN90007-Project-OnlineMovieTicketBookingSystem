DROP TABLE Cinema_Manager;

CREATE TABLE Cinema_Manager(
	cinema_manager_id INT GENERATED ALWAYS AS IDENTITY,
	firstname VARCHAR(100),
	lastname VARCHAR(100),
	PRIMARY KEY(cinema_manager_id)
);

