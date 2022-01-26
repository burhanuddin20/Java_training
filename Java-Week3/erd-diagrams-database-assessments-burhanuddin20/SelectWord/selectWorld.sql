-- Burhan Uddin
-- 06/08/2021

USE world;

-- Activity 1

SELECT *
FROM City
LIMIT 10;

SELECT *

FROM Country
LIMIT 10;

SELECT *

FROM Countrylanguage
LIMIT 10;

-- Activity 2

SELECT 
	Name AS City,
    Population
FROM City
WHERE population < 10000
ORDER BY population DESC;

-- Activity 3
SELECT 
	City.Name AS City,
    Country.Name CountryName,
    Country.Region
FROM city
RIGHT OUTER  JOIN Country ON Country.Code = City.CountryCode
GROUP BY Region,CountryName
ORDER BY city IS NULL ,Region,CountryName,city;

-- ACTIVITY 4
SELECT 
    Country.Name CountryName,
    Countrylanguage.Language,
    Countrylanguage.percentage
FROM Country
Inner JOIN CountryLanguage ON Country.Code = CountryCode
WHERE CountryLanguage.Language LIKE( '%french%')
ORDER BY CountryLanguage.percentage DESC;
-- If official percentage is set as 0

-- Activity 5

SELECT 
	Name,
    continent,
    population
FROM Country
WHERE IndepYear IS NULL;

-- Activity 6

SELECT 
    Country.Name CountryName,
    Countrylanguage.Language,
    Countrylanguage.percentage
FROM Country
LEFT OUTER JOIN CountryLanguage ON Country.Code = CountryCode
ORDER BY CountryName,CountryLanguage.percentage DESC;

-- Acitivity 7
SELECT 
    Country.Name CountryName,
    Country.Continent Continent
FROM Country
LEFT OUTER JOIN CountryLanguage ON Country.Code = CountryCode
WHERE CountryLanguage.Language IS NULL
ORDER BY Continent, CountryName;

-- Activity 8 
