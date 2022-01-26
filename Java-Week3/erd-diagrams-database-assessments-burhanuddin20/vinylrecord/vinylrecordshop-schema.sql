-- Burhan Uddin
-- 03/08/2021
DROP database IF EXISTS vinylrecordshop;

CREATE DATABASE vinylrecordshop;
USE vinylrecordshop; 
	
# create the album table

CREATE TABLE album(
	albumId INT AUTO_INCREMENT,
    albumTitle VARCHAR(100) NOT NULL,
    label VARCHAR(50),
	releaseDate DATE,
    price DECIMAL(5,2),
    CONSTRAINT pk_album
		PRIMARY KEY (albumId)


);

CREATE TABLE artist(
	artistId INT AUTO_INCREMENT,
	CONSTRAINT pk_artist
	PRIMARY KEY (artistId),
    artistFirstName VARCHAR(25)  NOT NULL,
    artistLastName VARCHAR(50)

);

CREATE TABLE band(
	bandId INT AUTO_INCREMENT,
	CONSTRAINT pk_band
	PRIMARY KEY (bandId),
    bandName VARCHAR(50)
);

CREATE TABLE song (
    songId INT NOT NULL AUTO_INCREMENT,
    songTitle VARCHAR(100) NOT NULL,
    videoUrl VARCHAR(100),
    CONSTRAINT pk_song 
    	PRIMARY KEY (songId)
);

DROP TABLE IF EXISTS song;
CREATE TABLE song (
    songId INT NOT NULL AUTO_INCREMENT,
    songTitle VARCHAR(100) NOT NULL,
    videoUrl VARCHAR(100),
    bandId INT NOT NULL,
    CONSTRAINT pk_song 
    	PRIMARY KEY (songId)
);

DROP TABLE IF EXISTS song;
CREATE TABLE song (
    songId INT NOT NULL AUTO_INCREMENT,
    songTitle VARCHAR(100) NOT NULL,
    videoUrl VARCHAR(100),
    bandId INT NOT NULL,
    CONSTRAINT pk_song 
    	PRIMARY KEY (songId),
    CONSTRAINT fk_song_band 
    	FOREIGN KEY (bandID)
    	REFERENCES band(bandId)
);

CREATE TABLE songAlbum (
    songId INT,
    albumId INT
);

DROP TABLE IF EXISTS songAlbum;
CREATE TABLE songAlbum (
    songId INT,
    albumId INT,
    CONSTRAINT pk_songAlbum 
    	PRIMARY KEY (songId, albumId)
);

DROP TABLE IF EXISTS songAlbum;
CREATE TABLE songAlbum (
    songId INT,
    albumId INT,
    CONSTRAINT pk_songAlbum 
    	PRIMARY KEY (songId, albumId),
    CONSTRAINT fk_songAlbum_song
    	FOREIGN KEY (songId)
    	REFERENCES song(songId),
    CONSTRAINT fk_songAlbum_album
    	FOREIGN KEY (albumId)
    	REFERENCES album(albumId)
);

DROP TABLE IF EXISTS bandArtist;
CREATE TABLE bandArtist (
    bandId INT,
    artistID INT,
    CONSTRAINT pk_bandId
    	PRIMARY KEY (bandId, artistId),
	CONSTRAINT fk_bandArtist_band
		FOREIGN KEY(bandId)
        REFERENCES band(bandId),
	CONSTRAINT fk_bandArtist_artist
		FOREIGN KEY (artistId)
        REFERENCES artist(artistId)
);

SHOW TABLES;




