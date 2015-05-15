SET DATABASE COLLATION SQL_TEXT_UCC;
DROP TABLE IF EXISTS categorias_novo;
CREATE TABLE address
(
	zipCode varchar(8) NOT NULL PRIMARY KEY,
	street varchar(250),
	district varchar(50),
	city varchar(100),
	state varchar(2)
);