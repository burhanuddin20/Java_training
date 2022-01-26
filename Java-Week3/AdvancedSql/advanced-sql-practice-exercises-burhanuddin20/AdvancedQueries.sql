-- Burhan Uddin
-- 09/08/2021


USE  TrackIt;


SHOW TABLES ;
SELECT DISTINCT firstName,LastName  FROM worker;


SELECT firstname FROM WORKER
UNION
SELECT LASTNAME FROM WORKER;

SELECT firstName,LastName FROM WORKER
WHERE EXISTS(SELECT ProjectId FROM PROJECTWORKER WHERE PROJECTWORKER.workerId = worker.workerId AND WORKER.WORKERID = 1);

SHOW TABLES;

SELECT FIRSTNAME,LASTNAME
FROM WORKER
WHERE WORKERID = ANY
  (SELECT workerId
  FROM projectWorker
  WHERE projectWorker.workerId = 1);
  
  
  SELECT firstname, lastname,
  CASE
    WHEN workerid = 1 THEN 'workerId is is 1'
    WHEN workerid = 2 THEN 'workerId is is 2'
    ELSE 'nO WORK'
END
FROM WORKER;
	
TRUNCATE TABLE TASK;
SHOW TABLES;

CREATE TABLE workerClone LIKE worker;
INSERT INTO workerClone SELECT * FROM WORKER;