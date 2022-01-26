-- Burhan Uddin
--  07/08/2021

drop database if exists BurhanUddinHotelDB;

create database BurhanUddinHotelDB;

use BurhanUddinHotelDB;

-- All tabels without FKs
create table room (
	roomNum INT NOT NULL primary key,
    standardOccupancy INT NOT NULL,
    maximumOccupancy INT NOT NULL
    
);


create table guest (
	guestId INT AUTO_INCREMENT  primary key,
    firstName VARCHAR(20) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
	lastName VARCHAR(40) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
	address VARCHAR(128) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    city VARCHAR(128) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    state VARCHAR(25) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    zip VARCHAR(20) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
    phone VARCHAR(15) NOT NULL
    
);

create table amenities (
	amenitiesId INT AUTO_INCREMENT primary key ,
    amenitiesName VARCHAR(20) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
	cost DECIMAL(5,2)  NULL
  
);



create table adaAccessible (
    adaAccessibleId INT  primary key AUTO_INCREMENT,
    accessibility VARCHAR(3) NOT NULL
);

create table typePrice (
    typesId INT  primary key AUTO_INCREMENT,
    bedtype VARCHAR(10) NOT NULL,
    rate DECIMAL(5,2) NOT NULL,
    personCost DECIMAL(5,2) NULL
);

-- Tables that use FKs



create table roomAdaAccessible (
    adaAccessibleId INT NOT NULL,
    roomNum INT NOT NULL ,
    PRIMARY KEY (adaAccessibleId,roomNum),
    FOREIGN KEY fk_room_adaAccessible(adaAccessibleId)
		REFERENCES adaAccessible(adaAccessibleId),
	FOREIGN KEY fk_roomAdaAccessible_roomNum(roomNum)
		REFERENCES room(roomNum)
    
);

create table roomType (
	typesId INT  NOT NULL,
    roomNum INT  NOT NULL,
    PRIMARY KEY (typesId,roomNum),
    
    FOREIGN KEY fk_roomType_typesId(typesId)
		REFERENCES typePrice(typesId),
	FOREIGN KEY fk_roomType_roomNum(roomNum)
		REFERENCES room(roomNum)
);

create table roomAmenities (
	amenitiesId INT  NOT NULL,
    roomNum INT  NOT NULL,
    PRIMARY KEY(amenitiesId,roomNum),
    FOREIGN KEY fk_roomAmenities_amenitiesId(amenitiesId)
		REFERENCES amenities(amenitiesId),
	FOREIGN KEY fk_roomAmenities_roomNum(roomNum)
		REFERENCES room(roomNum)
        
);

create table basePrice (
    basePriceId INT AUTO_INCREMENT  primary key,
    roomNum INT NOT NULL,
	cost DECIMAL (5,2) NOT NULL,
    FOREIGN KEY fk_basePrice_room(roomNum)
		REFERENCES room(roomNum)

);



create table reservation (
	reservationId INT AUTO_INCREMENT primary key NOT NULL,
	startDate DATE   NOT NULL,
    endDate DATE   NOT NULL,
    adults INT,
    children INT,
    guestId INT  NOT NULL,
    roomNum INT  NOT NULL,
    
    FOREIGN KEY fk_reservation_roomNum(roomNum)
		REFERENCES room(roomNum),
        
   FOREIGN KEY fk_reservation_guest(guestId)
		REFERENCES guest(guestId)
	
);

create table extraPeople (
    roomNum INT,
    totalCost DECIMAL(5,2)  NULL,
    reservationId INT,
    extraPeople INT,
	PRIMARY KEY(roomNum,reservationId),
    
    FOREIGN KEY fk_extraPeople_reservation(reservationId)
		REFERENCES reservation(reservationId),
	FOREIGN KEY fk_extraPeople_roomNum(roomNum)
		REFERENCES room(roomNum)
);



create table totalCost (
	reservationId INT primary key,
    cost Decimal (7,2)  NOT NULL,
 
    FOREIGN KEY fk_totalCost_reservation(reservationId)
		REFERENCES reservation(reservationId)

);

SHOW TABLES;


