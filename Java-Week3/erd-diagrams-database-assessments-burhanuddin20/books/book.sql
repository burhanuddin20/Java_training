-- Burhan Uddin
-- 03/08/2021
DROP database IF EXISTS books;

CREATE DATABASE books;
USE books; 
	
# create the album table

CREATE TABLE author(
	authorID INT AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(25) NOT NULL,
	middleName VARCHAR(25)  NULL,
    lastName VARCHAR(50) NOT NULL,
    gender VARCHAR(1) NOT NULL,
	dateofBrith DATE NOT NULL,
    dateofDeath DATE NULL,
    CONSTRAINT pk_author
		PRIMARY KEY (authorID)
);

CREATE TABLE book(
	bookID INT AUTO_INCREMENT NOT NULL,
	CONSTRAINT pk_book
	PRIMARY KEY (bookID),
    title VARCHAR(100)  NOT NULL,
    Publicationdate DATE

);


CREATE TABLE format (
    formatID INT NOT NULL AUTO_INCREMENT,
    formatName VARCHAR(12) NOT NULL,
    CONSTRAINT pk_format 
    	PRIMARY KEY (formatID)
);

CREATE TABLE genre (
    genreID INT NOT NULL AUTO_INCREMENT,
    genreName VARCHAR(25) NOT NULL,
    CONSTRAINT pk_genre
    	PRIMARY KEY (genreID)
);


CREATE TABLE authorbook (
    authorID INT NOT NULL,
    bookID INT NOT NULL,
    CONSTRAINT pk_authorbook 
    	PRIMARY KEY (authorID, bookID),
    CONSTRAINT fk_authorbook_author
    	FOREIGN KEY (authorID)
    	REFERENCES author(authorID),
    CONSTRAINT fk_authorbook_book
    	FOREIGN KEY (bookID)
    	REFERENCES book(bookID)
);



CREATE TABLE bookformat (
    formatID INT NOT NULL,
    bookID INT NOT NULL,
    Price DECIMAL(5,2) NULL,
    QuantityOnHand INT NULL,
    CONSTRAINT pk_bookformat 
    	PRIMARY KEY (formatID, bookID),
    CONSTRAINT fk_bookformat_format
    	FOREIGN KEY (formatID)
    	REFERENCES format(formatID),
    CONSTRAINT fk_bookformat_book
    	FOREIGN KEY (bookID)
    	REFERENCES book(bookID)
);


CREATE TABLE bookgenre (
    genreID INT NOT NULL,
    bookID INT NOT NULL,
    CONSTRAINT pk_bookgenre 
    	PRIMARY KEY (genreID, bookID),
    CONSTRAINT fk_bookgenre_bookgenre
    	FOREIGN KEY (genreID)
    	REFERENCES genre(genreID),
    CONSTRAINT fk_bookgenre_book
    	FOREIGN KEY (bookID)
    	REFERENCES book(bookID)
);

SHOW TABLES;
DESCRIBE bookgenre;




