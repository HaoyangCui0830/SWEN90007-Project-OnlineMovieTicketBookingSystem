DROP TABLE Cinema_Movie;

CREATE TABLE Cinema_Movie(
	movieId INT,
	cinemaID INT,
	PRIMARY KEY(movieId, cinemaId),
	FOREIGN KEY (movieId) REFERENCES Movies(movie_id),
	FOREIGN KEY (cinemaId) REFERENCES Cinema(cinema_id)
);

INSERT INTO Cinema_Movie VALUES (111,1)