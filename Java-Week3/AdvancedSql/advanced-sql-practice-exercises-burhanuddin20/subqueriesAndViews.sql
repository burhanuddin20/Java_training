-- Burhan Uddin
-- 09/08/2021


USE  TrackIt;

-- In keyword
SELECT *
FROM Worker
WHERE WorkerId IN (
    SELECT WorkerId FROM ProjectWorker
);

-- Subqueries
SELECT
    g.ProjectName,
    g.MinTaskId,
    t.Title MinTaskTitle
FROM Task t
INNER JOIN (
    SELECT
        p.Name ProjectName,
        MIN(t.TaskId) MinTaskId
    FROM Project p
    INNER JOIN Task t ON p.ProjectId = t.ProjectId
    GROUP BY p.ProjectId, p.Name) g ON t.TaskId = g.MinTaskId;
    
    
    SELECT
    w.FirstName,
    w.LastName,
    (SELECT COUNT(*) FROM ProjectWorker 
    WHERE WorkerId = w.WorkerId) ProjectCount
FROM Worker w;


CREATE VIEW ProjectNameWithMinTaskId
AS
SELECT
    p.Name ProjectName,
    MIN(t.TaskId) MinTaskId
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
GROUP BY p.ProjectId, p.Name;


SELECT * FROM ProjectNameWithMinTaskId;



SELECT
    pt.ProjectName,
    pt.MinTaskId TaskId,
    t.Title
FROM Task t
INNER JOIN ProjectNameWithMinTaskId pt -- Aliased just like a table.
    ON t.TaskId = pt.MinTaskId;
    
    
    

