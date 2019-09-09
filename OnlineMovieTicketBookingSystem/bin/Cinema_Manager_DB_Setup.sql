DROP TABLE Cinema_Manager;

CREATE TABLE Cinema_Manager(
	cinema_manager_id INT,
	firstname VARCHAR(100),
	lastname VARCHAR(100),
	PRIMARY KEY(cinema_manager_id)
);

INSERT INTO Cinema_Manager VALUES (1, 'Hannah', 'Yang')