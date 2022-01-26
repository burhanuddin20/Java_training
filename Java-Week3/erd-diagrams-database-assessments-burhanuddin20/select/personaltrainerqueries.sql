USE PersonalTrainer;

SELECT * 
FROM Exercise;

SELECT *
FROM Client;

SELECT * 
FROM Client
WHERE City = "Metairie";

SELeCT * FROM Client
WHERE ClientId = "818u7faf-7b4b-48a2-bf12-7a26c92de20c";

SELECT * 
FROM Goal;

SELECT name,levelid 
FROM Workout;

SELECT name,levelid, Notes
FROM Workout
WHERE Levelid = 2;


SELECT FirstName, LastName, City
FROM Client
WHERE City = "Metairie" OR CITY = "Kenner" OR CITY = "Gretna";

SELECT FirstName, LastName, BirthDate
FROM Client
WHERE BirthDate BETWEEN '1980-01-01' AND '1990-01-01';

SELECT FirstName, LastName, BirthDate
FROM Client
WHERE BirthDate LIKE '%198%';

SELECT * 
FROM Login
WHERE EmailAddress LIKE '%.gov';

SELECT *
FROM Login
WHERE EmailAddress NOT LIKE '%.com';

SELECT FirstName, LastName
FROM Client
WHERE BirthDate IS NULL; 

SELECT Name
FROM ExerciseCategory
WHERE ParentCategoryId IS NOT NULL; 


SELECT Name, Notes
FROM Workout
WHERE LEVELId = 3 AND Notes LIKE '%you%';

SELECT FirstName, LastName, City
FROM Client
WHERE City = "LaPlace" AND (LastName LIKE 'L%'OR LastName LIKE 'M%' OR LastName LIKE 'N%');

SHOW Tables;
DESCRIBE InvoiceLineItem;

SELECT 
		InvoiceId, 
        Description,
        Price,
        Quantity,
        ServiceDate,
        (Price*Quantity) AS line_item_total
FROM InvoiceLineItem
WHERE Price*Quantity BETWEEN 15 AND 25;

Describe Login;

SELECT *
 FROM Login
WHERE ClientId = (SELECT ClientId  From Client WHERE FirstName = 'Estrella' AND LastName = 'Bazely');

;

SELECT name
FROM Goal 
WHERE GoalId IN (SELECT GoalId 
FROM WorkoutGoal
WHERE WorkOutId = (SELECT WorkoutId 
FROM Workout
WHERE Name = 'This is Parkour'));

