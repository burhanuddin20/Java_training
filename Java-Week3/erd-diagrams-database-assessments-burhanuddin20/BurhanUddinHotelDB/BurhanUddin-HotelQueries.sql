-- Burhan Uddin
--  07/08/2021


use BurhanUddinHotelDB;





--  1.Write a query that returns a list of reservations that end in July 2023, including the name of the guest, the room number(s), and the reservation dates.

SELECT 
	guest.FirstName,
	guest.LastName,
	reservation.roomNum,
	reservation.startDate,
    reservation.endDate
    
FROM reservation 
INNER JOIN  guest ON reservation.guestId = guest.guestId
WHERE reservation.endDate < '2023-08-01';
/*

# FirstName	LastName	roomNum	startDate	endDate
Mack	Simmer	308	2023-02-02	2023-04-02
Duane	Cullison	305	2023-02-22	2023-02-24
Karie	Yang	201	2023-06-03	2023-07-03
Burhan	Uddin	307	2023-03-17	2023-03-20
Aurore	Lipton	302	2023-03-18	2023-03-23
Zachery	Luechtefeld	202	2023-03-29	2023-03-31
Walter	Holaway	301	2023-04-09	2023-04-05
Wilfred	Vise	207	2023-04-23	2023-04-24
Maritza	Tilton	401	2023-05-30	2023-06-02
Joleen	Tison	206	2023-10-06	2023-06-14
Joleen	Tison	208	2023-10-06	2023-06-14
Aurore	Lipton	304	2023-06-17	2023-06-18
Burhan	Uddin	205	2023-06-28	2023-02-07
Walter	Holaway	204	2023-07-13	2023-07-14
Wilfred	Vise	401	2023-07-18	2023-07-21
Bettyann	Seery	303	2023-07-28	2023-07-29
Bettyann	Seery	305	2023-08-30	2023-01-09

*/

-- 2.Write a query that returns all the rooms reserved for a specific guest, including the guest's name, the room(s) reserved, the starting date of the reservation, and how many people were included in the reservation. (Choose a guest's name from the existing data.)

SELECT 
	guest.FirstName,
	guest.LastName,
    (reservation.adults + reservation.children) AS numberOfPeople,
	reservation.roomNum,
	reservation.startDate
    
FROM reservation
JOIN guest on guest.guestId = reservation.guestId AND guest.firstName = 'Walter' AND guest.lastName = 'Holaway';

-- Walter	Holaway
/*
# FirstName	LastName	numberOfPeople	roomNum	startDate
Walter	Holaway	1	301	2023-04-09
Walter	Holaway	4	204	2023-07-13

*/

-- 3.Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation. The results should include all rooms, whether or not there is a reservation associated with the room.

SELECT 
	room.roomNum,
	reservation.reservationId,
    totalcost.cost
FROM room
LEFT OUTER JOIN reservation ON room.roomNum = reservation.roomNum
LEFT JOIN  totalcost ON totalcost.reservationId = reservation.reservationId;

/*

List of all rooms w or w/out reservations
# roomNum	reservationId	cost
201	4	199.99
202	7	349.98
203	2	999.95
203	21	399.98
204	16	184.99
205	15	699.96
206	12	599.96
206	23	449.97
207	10	174.99
208	13	599.96
208	20	149.99
301	9	799.96
301	24	599.97
302	6	924.95
302	25	699.96
303	18	199.99
304	14	184.99
305	3	349.98
305	19	349.98
306		
307	5	524.97
308	1	299.98
401	11	1199.97
401	17	1259.97
401	22	1199.97
402		


*/

-- 4.Write a query that returns all rooms with a capacity of three or more and that are reserved on any date in April 2023.

SELECT 
	ROOM.roomNum
FROM room
Inner JOIN reservation ON reservation.roomNum = room.roomNum
WHERE room.maximumOccupancy >= 3 AND ((reservation.startDate BETWEEN '2023-04-01' AND '2023-05-01')  OR (reservation.endDate BETWEEN '2023-04-01' AND '2023-05-01'));

/*
# roomNum
301

*/

-- 5.Write a query that returns a list of all guest names and the number of reservations per guest, sorted starting with the guest with the most reservations and then by the guest's last name.

SELECT 
	guest.FirstName,
	guest.LastName,
    COUNT(reservation.reservationId) AS numberOfReservations
FROM reservation
JOIN guest on guest.guestId = reservation.guestId
GROUP BY guest.FirstName, guest.lastName
ORDER BY numberOfReservations DESC, guest.lastName;

/*
# FirstName	LastName	numberOfReservations
Mack	Simmer	4
Bettyann	Seery	3
Duane	Cullison	2
Walter	Holaway	2
Aurore	Lipton	2
Maritza	Tilton	2
Joleen	Tison	2
Burhan	Uddin	2
Wilfred	Vise	2
Karie	Yang	2
Zachery	Luechtefeld	1





*/

-- 6.Write a query that displays the name, address, and phone number of a guest based on their phone number. (Choose a phone number from the existing data.)

-- (291) 553-0508

SELECT firstName,
		LastName,
		address,
        phone
FROM guest
WHERE phone = '(291) 553-0508';

/* Chose (291) 553-0508
# firstName	LastName	address	phone
Mack	Simmer	379 Old Shore Street	(291) 553-0508

*/