DROP TABLE IF EXISTS USER;

CREATE TABLE STUDENT (
	first_name VARCHAR(250) NOT NULL,
	last_name VARCHAR(250) NOT NULL,
	password VARCHAR(250) NOT NULL,
	email VARCHAR(250) PRIMARY KEY NOT NULL,
	user_type VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS TEST;

CREATE TABLE TEST (
	test_date DATE NOT NULL,
	assessment VARCHAR(250) NOT NULL,
	marks int(32) NOT NULL,
	email VARCHAR(250) PRIMARY KEY NOT NULL,
	result VARCHAR(250) DEFAULT NULL
);