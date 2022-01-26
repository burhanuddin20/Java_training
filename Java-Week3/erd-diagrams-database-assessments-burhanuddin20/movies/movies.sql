-- Burhan Uddin
-- 03/08/2021
DROP DATABASE IF EXISTS movies;

CREATE DATABASE movies;
USE movies; 
	


CREATE TABLE genre (
    genreID INT AUTO_INCREMENT NOT NULL,
    genreName VARCHAR(30) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    CONSTRAINT pk_genre
    	PRIMARY KEY (genreID)
);




CREATE TABLE director (
    directorID INT AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(30) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    lastName VARCHAR(30) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    birthDate DATE NULL,
    CONSTRAINT pk_director
    	PRIMARY KEY (directorID)
);

CREATE TABLE rating (
    ratingID INT AUTO_INCREMENT NOT NULL,
    ratingName VARCHAR(5) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    CONSTRAINT pk_rating
    	PRIMARY KEY (ratingID)
);




CREATE TABLE actor (
    actorID  INT NOT NULL,
    firstName VARCHAR(30) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    lastName VARCHAR(30) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    birthDate DATE NULL,
    CONSTRAINT pk_actor
    	PRIMARY KEY (actorID)
    
);

CREATE TABLE movie(
	movieID INT AUTO_INCREMENT NOT NULL,
    genreID INT NOT NULL,
    title VARCHAR(128) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
	directorID INT NULL,
    ratingID INT NULL,
	releaseDate DATE NULL,
    
    CONSTRAINT pk_movie
		PRIMARY KEY (movieID),
	CONSTRAINT fk_movie_genre
    	FOREIGN KEY (genreID)
    	REFERENCES genre(genreID),
	CONSTRAINT fk_movie_director
    	FOREIGN KEY (directorID)
    	REFERENCES director(directorID),
	CONSTRAINT fk_movie_rating
    	FOREIGN KEY (ratingID)
    	REFERENCES rating(ratingID)
      
);



CREATE TABLE castMembers (
    castMemberID INT AUTO_INCREMENT NOT NULL,
    actorID INT NOT NULL,
	movieID INT NOT NULL,
    role  VARCHAR(50) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    CONSTRAINT pk_castMembers
    	PRIMARY KEY (castMemberID),
    CONSTRAINT fk_castMembers_actor
    	FOREIGN KEY (actorID)
    	REFERENCES actor(actorID),
    CONSTRAINT fk_castMembers_movie
    	FOREIGN KEY (movieId)
    	REFERENCES movie(movieID)
);

-- test queries

SHOW TABLES;
DESCRIBE movie;




