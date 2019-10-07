DROP TABLE Ticket;

CREATE TABLE Ticket(
	ticket_id INT GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(150),
	movie_id INT,
	session_id INT,
	cinema_id INT,
	seatNumber INT,
	PRIMARY KEY(ticket_id)
--	FOREIGN KEY (movie_id) REFERENCES Movies(movie_id),
--	FOREIGN KEY (session_id) REFERENCES Sessions(session_id)
);



