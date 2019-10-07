DROP TABLE t_user;

CREATE TABLE t_user(
	user_id INT GENERATED ALWAYS AS IDENTITY,
	username VARCHAR(150),
	password VARCHAR(150),
	role VARCHAR(150),
	first_name VARCHAR(150),
	last_name VARCHAR(150),
	PRIMARY KEY(username)
--	FOREIGN KEY (movie_id) REFERENCES Movies(movie_id),
--	FOREIGN KEY (session_id) REFERENCES Sessions(session_id)
);



