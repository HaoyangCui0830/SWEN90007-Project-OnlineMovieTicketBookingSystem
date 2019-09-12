
INSERT INTO Movies (name, length, price) VALUES ('THE LION KING', '01:58:00', 20.00);
INSERT INTO Movies (name, length, price) VALUES ('JOKER', '01:45:00', 22.00);
INSERT INTO Movies (name, length, price) VALUES ('APOLLO 11', '01:33:00', 18.00);


INSERT INTO Customer (firstname, lastname) VALUES ('Haoyang', 'Cui');

INSERT INTO ThreeDMovies (ThreeDMovie_id, has_free_glasses) VALUES (1,true);

INSERT INTO Cinema (name, ADDRESS) VALUES('Melbourne IMax', 'CARLTON');
INSERT INTO Cinema (name, ADDRESS) VALUES('Sydney IMax', 'Darling Harbour');


INSERT INTO sessions (startTime, endTime, MovieId, total_seats, available_seats) VALUES ('09:00:00','10:58:00',1,100,100);
INSERT INTO sessions (startTime, endTime, MovieId, total_seats, available_seats) VALUES ('13:00:00','14:45:00',2,100,100);
INSERT INTO sessions (startTime, endTime, MovieId, total_seats, available_seats) VALUES ('17:00:00','18:33:00',3,100,100);

INSERT INTO Cinema_Manager (firstname, lastname) VALUES ('Hannah', 'Yang');

INSERT INTO Cinema_Movie VALUES (1,1);
INSERT INTO Cinema_Movie VALUES (2,1);
INSERT INTO Cinema_Movie VALUES (3,2);
