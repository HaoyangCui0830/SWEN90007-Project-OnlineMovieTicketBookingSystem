DROP TABLE Lock;

CREATE TABLE Lock(
	tableName VARCHAR(50),
	id  VARCHAR(50),
	owner VARCHAR(200),
	PRIMARY KEY(tableName, id, owner)
);