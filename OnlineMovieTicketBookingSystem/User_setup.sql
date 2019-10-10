DROP TABLE users;

CREATE TABLE users(
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


INSERT INTO users (username, password, role, first_name, last_name) VALUES ('hannah', '1q2w3e4r', 'manager', 'hannah', 'yang');
INSERT INTO users (username, password, role, first_name, last_name) VALUES ('admin', '12345678', 'manager', 'admin', 'manager');
INSERT INTO users (username, password, role, first_name, last_name) VALUES ('haoyang', '1q2w3e4r', 'customer', 'haoyang', 'cui');
