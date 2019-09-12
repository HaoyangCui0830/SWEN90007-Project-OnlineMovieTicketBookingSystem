DROP TABLE sessions;

CREATE TABLE sessions(
	session_id INT GENERATED ALWAYS AS IDENTITY,
	startTime TIME,
	endTime TIME,
	MovieId INT,
	total_seats INT,
	available_seats INT,
	PRIMARY KEY(session_id,MovieId),
	FOREIGN KEY (MovieId) REFERENCES Movies(movie_id)
	
);

