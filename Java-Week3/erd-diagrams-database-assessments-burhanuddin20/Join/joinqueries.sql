-- Burhan Uddin
-- 05/08/2021


USE PersonalTrainer;
DESCRIBE exercisecategory;
DESCRIBE exercise;

-- Activity1
--  Select all columns from exericsecategory and exercise joined by exercisecategoryid
SELECT * FROM exercisecategory
INNER JOIN exercise ON exercise.ExerciseCategoryId = exercisecategory.ExerciseCategoryId;


-- Actitivity 2
-- Select exercesie name anmd category if parentcategoryhid is null
SELECT
	exercisecategory.Name,
    exercise.Name
FROM exercisecategory
INNER JOIN exercise ON exercise.ExerciseCategoryId = exercisecategory.ExerciseCategoryId
WHERE ParentCategoryId IS NULL;

-- Acitivty3
-- Use aliases to make output more readable

SELECT
	a.Name CatergoryName,
    b.Name ExerciseName
FROM exercisecategory a
INNER JOIN exercise b ON b.ExerciseCategoryId = a.ExerciseCategoryId
WHERE a.ParentCategoryId IS NULL;

-- Activity 4
-- Join tables and return clients with birthdates in the 90s
-- Client ID is the primary key and the fk to the log in table

SELECT FirstName,
		LastName,
        BirthDate
FROM Client
INNER JOIN login on login.ClientId = client.ClientId
WHERE BirthDate LIKE '%99%';

-- Activity 5
-- Order of Joins matter statements matters

SELECT workout.Name,
		Client.FirstName,
        Client.LastName
         
FROM WorkOut
INNER JOIN clientworkout on ClientWorkout.workoutId = workout.workoutId 
INNER JOIN client on client.ClientId = clientworkout.ClientId
WHERE Client.LastName LIKE 'C%';


-- Activity 6


SELECT
	w.Name WorkoutName,
    g.Name GoalName
    
FROM WorkOut w

INNER JOIN WorkoutGoal wg on wg.workoutId = w.workoutId
INNER JOIN goal g on g.GoalId = wg.Goalid;

-- Activity 7 

-- Inner join only gives 300 rows because null values are not included
-- Have to use left outer join
-- HOW TO SET UP CLIENTS WHO DO NOT HAVE LOGIN I.E THEIR LOGIN FIELD IS NULL

SELECT 
	Client.FirstName,
    Client.LastName,
    Login.ClientId,
    Login.emailaddress
    
FROM Client
LEFT OUTER JOIN login ON client.ClientId = Login.clientId
WHERE login.clientID IS NULL;

-- Activity 8 
-- no login
SELECT 
	IFNULL(login.clientID,0) AS LoginStatus
FROM Client
LEFT OUTER JOIN login ON client.ClientId = Login.clientId
WHERE CLIENT.FirstName = 'Romeo' AND client.LastName = 'Seaward';


-- Activity 9 
-- self join


SELECT
	parent.Name ParentExerciseCategory,
	child.Name ExercsieCategoryName
    FROM ExerciseCategory parent
    INNER JOIN ExerciseCategory child on parent.ParentCategoryId = child.exerciseCategoryId;
    
-- Activity 10
-- same as above but get the null values
 
 SELECT
	parent.Name ParentExerciseCategory,
	child.Name ExercsieCategoryName
    FROM ExerciseCategory parent
    LEFT OUTER JOIN ExerciseCategory child on parent.ParentCategoryId = child.exerciseCategoryId;

-- Activity 11

-- Clients not signed up for workout
-- COMPARE CLIENT AND CLIENT WORKOUT, NEED TO GET THE ONES WITH NULL WORKOUTID
SELECT 
	Client.FirstName,
    Client.LastName,
    Client.CLIENTId,
    ClientWorkout.workoutid
    FROM client
	LEFT OUTER JOIN ClientWorkout on  client.clientId =ClientWorkout.clientID
    WHERE ClientWorkout.workoutid IS NULL;


    
-- Activity 12
-- Shell Creane's Beginner level goals
-- Goals -> ClientGoal -> clients .
-- Goals -> workoutGoal -> Workouts

SELECT 
	Workout.Name,
    Workout.LevelId
FROM Workout
INNER JOIN WorkoutGoal on WorkoutGoal.WorkoutId = Workout.WorkOutId
INNER JOIN Goal on Goal.GoalId = WorkoutGoal.GoalId
INNER JOIN ClientGoal on clientgoal.goalid = goal.goalid
INNER JOIN client on client.clientid = clientgoal.clientid
WHERE client.FirstName = 'Shell' AND client.LastName = 'Creane' AND WorkOut.LevelId = 1;



-- Activity 13
-- GoalId = 10
-- 26 Workouts
-- 14 goals
-- Don't get what they want

SELECT
	Workout.Name WorkOutName,
    Goal.Name Goal

FROM WORKOUT
INNER JOIN WorkoutGoal on WorkoutGoal.workoutid = Workout.WorkoutId
INNER  JOIN Goal on Goal.GoalID = WorkoutGoal.goalID AND WorkoutGoal.goalId = 10;

SELECT * FROM Goal;


    