-- Burhan Uddin
--  07/08/2021

use BurhanUddinHotelDB;

SHOW TABLES;

-- Insert guest data
INSERT INTO `guest` VALUES (1,'Burhan','Uddin','555 Gretna road','London','LDN','EW135JS','123456789'),
(2,'Mack','Simmer','379 Old Shore Street','Council Bluffs','IA','51501','(291) 553-0508'),
(3,'Bettyann','Seery','750 Wintergreen Dr.','Wasilla','AK','99654','(478) 277-9632'),
(4,'Duane','Cullison','9662 Foxrun Lane','Harlingen','TX','78552','(308) 494-0198'),
(5,'Karie','Yang','9378 W. Augusta Ave.','West Deptford','NJ','8096','(214) 730-0298'),
(6,'Aurore','Lipton','762 Wild Rose Street','Saginaw','MI','48601','(377) 507-0974'),
(7,'Zachery','Luechtefeld','7 Poplar Dr.','Arvada','CO','80003','(814) 485-2615'),
(8,'Jeremiah','Pendergrass','70 Oakwood St.','Zion','IL','60099','(279) 491-0960'),
(9,'Walter','Holaway','7556 Arrowhead St.','Cumberland','RI','2864','(446) 396-6785'),
(10,'Wilfred','Vise','77 West Surrey Street','Oswego','NY','13126','(834) 727-1001'),
(11,'Maritza','Tilton','939 Linda Rd.','Burke','VA','22015','(446) 351-6860'),
(12,'Joleen','Tison','87 Queen St.','Drexel Hill','PA','19026','(231) 893-2755');

INSERT INTO `amenities` VALUES (1,'Microwave',NULL),(2,'Jacuzzi',25.00),
(3,'Refrigerator',NULL),
(4,'Oven',NULL),
(5,'Electric stove',NULL);




INSERT INTO `adaaccessible` VALUES (1,'yes'),(2,'no');

INSERT INTO `room` VALUES (201,2,4),
(202,2,4),(203,2,4),(204,2,4),
(205,2,2),(206,2,2),(207,2,2),
(208,2,2),(301,2,4),(302,2,4),(303,2,4),
(304,2,4),(305,2,2),(306,2,2),(307,2,2),
(308,2,2),(401,3,8),(402,3,8);

INSERT INTO `roomadaaccessible` VALUES (2,201),(1,202),(2,203),(1,204),
(2,205),(1,206),(2,207),(1,208),(2,301),(1,302),(2,303),(1,304),(2,305),
(1,306),(2,307),(1,308),(1,401),(1,402);

INSERT INTO `typeprice` VALUES (1,'single',149.99,NULL),(2,'double ',174.99,10.00),(3,'suite',399.99,20.00);

INSERT INTO `roomtype` VALUES (2,201),(2,202),(2,203),(2,204),(1,205),(1,206),
(1,207),(1,208),(2,301),(2,302),(2,303),(2,304),(1,305),(1,306),
(1,307),(1,308),(3,401),(3,402);

INSERT INTO `roomamenities` VALUES (1,201),(2,201),(3,202),(2,203),(1,203),(3,204),(3,205),
(2,205),(1,205),(1,206),(3,206),(1,207),(3,207),(2,207),(3,208),(1,208),(2,301),(1,301),
(3,302),(1,303),(2,303),(3,304),(3,305),(2,305),(1,305),(1,306),(3,306),(1,307),(2,307),
(3,307),(1,308),(3,308),(4,401),(3,401),(1,401),(1,402),(3,402),(4,402);



INSERT INTO `reservation` VALUES (1,'2023-02-02','2023-02-04',1,0,2,308),(2,'2023-05-02','2023-10-02',2,1,3,203),
(3,'2023-02-22','2023-02-24',2,0,4,305),
(4,'2023-06-03','2023-07-03',2,2,5,201),
(5,'2023-03-17','2023-03-20',1,1,1,307),
(6,'2023-03-18','2023-03-23',3,0,6,302),
(7,'2023-03-29','2023-03-31',2,2,7,202),
(8,'2023-03-31','2023-05-04',2,0,8,304),
(9,'2023-04-09','2023-04-05',1,0,9,301),
(10,'2023-04-23','2023-04-24',1,1,10,207),
(11,'2023-05-30','2023-06-02',2,4,11,401),
(12,'2023-10-06','2023-06-14',2,0,12,206),
(13,'2023-10-06','2023-06-14',1,0,12,208),
(14,'2023-06-17','2023-06-18',3,0,6,304),(15,'2023-06-28','2023-02-07',2,0,1,205),
(16,'2023-07-13','2023-07-14',3,1,9,204),(17,'2023-07-18','2023-07-21',4,2,10,401),
(18,'2023-07-28','2023-07-29',2,1,3,303),(19,'2023-08-30','2023-01-09',1,0,3,305),
(20,'2023-09-16','2023-09-17',2,0,2,208),(21,'2023-09-13','2023-09-15',2,2,5,203),
(22,'2023-11-22','2023-11-25',2,2,4,401),(23,'2023-11-22','2023-11-25',2,0,2,206),
(24,'2023-11-22','2023-11-25',2,2,2,301),(25,'2023-11-24','2023-12-28',2,0,11,302);

INSERT INTO `extrapeople` VALUES (201,0.00,4,0),(202,0.00,7,0),(203,0.00,2,0),(203,0.00,21,0),(204,10.00,16,1),(205,0.00,15,0),(206,0.00,12,0),(206,0.00,23,0),(207,10.00,10,1),(208,10.00,13,1),(208,0.00,20,0),(301,10.00,9,1),(301,0.00,24,0),(302,10.00,6,1),(302,0.00,25,0),(303,0.00,18,0),(304,0.00,8,0),(304,10.00,14,1),(305,0.00,3,0),(305,10.00,19,1),(307,10.00,5,1),(308,10.00,1,1),(401,0.00,11,0),(401,20.00,17,1),(401,0.00,22,0);

INSERT INTO `baseprice` VALUES (1,201,199.99),(2,202,174.99),(3,203,199.99),(4,204,174.99),(5,205,174.99),(6,206,149.99),(7,207,174.99),(8,208,149.99),(9,301,199.99),(10,302,174.99),(11,303,199.99),(12,304,174.99),(13,305,174.99),(14,306,149.99),(15,307,174.99),(16,308,149.99),(17,401,399.99),(18,402,399.99);

INSERT INTO `totalcost` VALUES (1,299.98),(2,999.95),(3,349.98),(4,199.99),(5,524.97),(6,924.95),(7,349.98),(8,874.95),(9,799.96),(10,174.99),(11,1199.97),(12,599.96),(13,599.96),(14,184.99),(15,699.96),(16,184.99),(17,1259.97),(18,199.99),(19,349.98),(20,149.99),(21,399.98),(22,1199.97),(23,449.97),(24,599.97),(25,699.96);

-- Deleting Jeremiah Pendergrass



-- host table 
DELETE extrapeople.* FROM extrapeople
INNER JOIN reservation ON reservation.reservationId = extraPeople.reservationId
WHERE reservation.reservationId = (SELECT reservationId 
FROM reservation
INNER JOIN guest ON guest.guestId = reservation.guestId
WHERE guest.firstName = 'Jeremiah' AND guest.lastName = 'Pendergrass' );

-- host table
DELETE totalcost.* FROM totalcost
INNER JOIN reservation ON reservation.reservationId = totalcost.reservationId
WHERE reservation.reservationId = (SELECT reservationId 
FROM reservation
INNER JOIN guest ON guest.guestId = reservation.guestId
WHERE guest.firstName = 'Jeremiah' AND guest.lastName = 'Pendergrass' );

-- host table
DELETE reservation.* FROM reservation
INNER JOIN guest ON guest.guestId = reservation.guestId
WHERE guest.firstName = 'Jeremiah' AND guest.lastName = 'Pendergrass';

-- Parent table
SET SQL_SAFE_UPDATES = 0;
DELETE guest.* FROM guest
WHERE guest.firstName = 'Jeremiah' AND guest.lastName = 'Pendergrass';
SET SQL_SAFE_UPDATES = 1;


