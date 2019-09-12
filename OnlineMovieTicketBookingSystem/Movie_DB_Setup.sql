DROP TABLE Movies;

CREATE TABLE Movies(
	movie_id INT GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(150),
	length TIME,
	price FLOAT,
	PRIMARY KEY (movie_id)
);
