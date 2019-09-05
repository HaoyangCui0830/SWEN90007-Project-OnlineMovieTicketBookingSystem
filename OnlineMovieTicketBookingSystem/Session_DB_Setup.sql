DROP TABLE sessions;

CREATE TABLE sessions(
	session_id INT,
	startTime TIME,
	endTime TIME,
	MovieId INT,
	total_seats INT,
	available_seats INT,
	PRIMARY KEY(session_id,MovieId),
	FOREIGN KEY (MovieId) REFERENCES Movies(movie_id)
	
);

INSERT INTO sessions VALUES (1,'09:00:00','10:58:00',111,100,100);
INSERT INTO sessions VALUES (2,'13:00:00','14:45:00',112,100,100);
INSERT INTO sessions VALUES (3,'17:00:00','18:33:00',113,100,100);