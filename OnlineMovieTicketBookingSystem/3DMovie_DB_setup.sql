DROP TABLE ThreeDMovies;

CREATE TABLE ThreeDMovies(
	ThreeDMovie_id INT,
	has_free_glasses BOOLEAN,
	PRIMARY KEY(ThreeDMovie_id),
	FOREIGN KEY (ThreeDMovie_id) REFERENCES Movies(movie_id)
);



