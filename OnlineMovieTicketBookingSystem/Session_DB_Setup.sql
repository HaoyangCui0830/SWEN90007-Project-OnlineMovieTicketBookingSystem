DROP TABLE sessions;

CREATE TABLE sessions(
	id INT,
	theaterId INT,
	MovieId INT,
	Number_of_seats INT,
	PRIMARY KEY(id,MovieId),
	FOREIGN KEY (MovieId) REFERENCES Movies(id)
	
);

INSERT INTO sessions VALUES (1,1,111,100);