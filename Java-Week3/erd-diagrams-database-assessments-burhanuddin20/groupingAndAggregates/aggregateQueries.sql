-- Burhan Uddin
-- 06/08/2021

USE PersonalTrainer;

-- Activity 1
SELECT COUNT(*)
FROM Client;

-- Activity 2
-- Not everyone entered there birthdates
SELECT COUNT(Client.BirthDate)
FROM Client;

-- Activity 3
SELECT 
	Client.city,
	COUNT(Client.City)

FROM Client
GROUP BY city;

-- Activity 4
DESCRIBE invoiceLineItem;

SELECT 
	invoiceid,
    SUM(price*quantity) AS invoice_total
FROM invoiceLineItem
GROUP BY invoiceid;

-- Activity 5

SELECT 
	invoiceid,
    SUM(price*quantity) AS invoice_total
FROM invoiceLineItem
GROUP BY invoiceid
HAVING invoice_total>500
ORDER BY invoice_total asc;

-- Activity 6

DESCRIBE InvoiceLineItem;
SELECT 
	InvoiceLineItem.Description,
    AVG (price*quantity) AS invoice_average
FROM InvoiceLineItem
GROUP BY InvoiceLineItem.Description;

-- Activity 7
-- 146 rows

SELECT
    Client.clientId,
    Client.FirstName,
    Client.LastName,   
    Invoice.invoiceId, -- sanity check
    SUM(price*quantity) AS Total
FROM invoiceLineItem
INNER JOIN Invoice on Invoice.InvoiceId = invoiceLineItem.InvoiceId AND Invoice.invoiceStatus = 2
INNER JOIN Client on invoice.ClientId = client.clientId  
GROUP BY Client.ClientId
 HAVING Total>1000
 ORDER BY LastName,FirstName;


-- Activity 8

SELECT 
	ExerciseCategory.Name AS CategoryName,
    COUNT(Exercise.ExerciseCategoryId) AS ExerciseCount
    FROM ExerciseCategory
    JOIN exercise on exercise.exerciseCategoryId = ExerciseCategory.ExerciseCategoryId
Group BY ExerciseCategory.Name
ORDER BY ExerciseCount DESC;

-- Activity 9

SELECT 
	Exercise.Name AS ExerciseName,
    MIN(ExerciseInstance.Sets) AS MinSets,
	MAX(ExerciseInstance.Sets) AS MaxSets,
    AVG(ExerciseInstance.Sets) AS AvgSets
    FROM Exercise
    JOIN ExerciseInstance on ExerciseInstance.ExerciseId = Exercise.ExerciseId
Group BY Exercise.Name
ORDER BY Exercise.Name;

-- Activity 10

SELECT 
	Workout.Name AS WorkoutName,
    MIN(Client.BirthDate) AS EarliestBirthDate,
	MAX(Client.BirthDate) AS latestestBirthDate
    FROM Workout
    JOIN ClientWorkout on ClientWorkout.WorkoutId = Workout.WorkoutId
    JOIN Client on Client.ClientId = ClientWorkout.ClientId
Group BY Workout.Name
ORDER BY WorkOut.Name;

-- Activity 11
SELECT 
	Client.ClientId AS WorkoutName,
    IFNULL(Count(Goal.GoalId),0)AS GoalCount
    FROM Client
    LEFT OUTER JOIN ClientGoal on Client.ClientId = ClientGoal.ClientId 
    LEFT OUTER JOIN Goal on Goal.GoalId = ClientGoal.GoalId
Group BY Client.ClientId
ORDER BY GoalCount ASC;


-- Activity 12
Select 
	Exercise.Name AS ExerciseName, 
    Unit.Name AS UnitName, 
    MIN(ExerciseInstanceUnitValue.Value) AS MinValue,
    Max(ExerciseInstanceUnitValue.Value) AS Max_Value
FROM Exercise
INNER JOIN ExerciseInstance ON ExerciseInstance.ExerciseID = Exercise.ExerciseId
INNER JOIN ExerciseInstanceUnitValue ON ExerciseInstanceUnitValue.ExerciseInstanceId = ExerciseInstance.ExerciseInstanceId
INNER JOIN Unit ON Unit.UnitId = ExerciseInstanceUnitValue.UnitId
GROUP BY Exercise.Name
ORDER BY Exercise.Name,Unit.Name;

-- Activity 13

Select 
	ExerciseCategory.Name AS CategoryName,
	Exercise.Name AS ExerciseName, 
    Unit.Name AS UnitName, 
    MIN(ExerciseInstanceUnitValue.Value) AS MinValue,
    Max(ExerciseInstanceUnitValue.Value) AS Max_Value
FROM Exercise
Inner JOIN ExerciseCategory ON ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
INNER JOIN ExerciseInstance ON ExerciseInstance.ExerciseID = Exercise.ExerciseId
INNER JOIN ExerciseInstanceUnitValue ON ExerciseInstanceUnitValue.ExerciseInstanceId = ExerciseInstance.ExerciseInstanceId
INNER JOIN Unit ON Unit.UnitId = ExerciseInstanceUnitValue.UnitId
GROUP BY Exercise.Name
ORDER BY ExerciseCategory.Name, Exercise.Name,Unit.Name;

-- Activity 14

Select 
	Level.Name AS LevelName, 
    
    datediff( now() ,Max(Client.BirthDate))/365 AS MinAge,
    datediff( now(),Min(Client.BirthDate))/365 AS MaxAge
FROM Level
INNER JOIN Workout ON Workout.LevelId = level.LevelId
INNER JOIN ClientWorkout ON ClientWorkout.WorkoutId = Workout.WorkoutId
INNER JOIN Client ON Client.ClientId = ClientWorkout.ClientId
GROUP BY Level.Name;

-- Activity 15

SELECT EMAILADDRESS,
		substring(EMAILADDRESS,locate('.',EmailAddress) + 1,length(EMAILADDRESS))
FROM LOGIN;




