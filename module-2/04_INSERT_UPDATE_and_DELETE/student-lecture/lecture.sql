
SELECT *
FROM countrylanguage;

INSERT INTO <table>(available columns)
VALUES (<values>)



-- INSERT

-- 1. Add Klingon as a spoken language in the USA
INSERT INTO countrylanguage
(
        countrycode
        ,language
        ,isofficial
        ,percentage
)
VALUES
(
        'USA'
        ,'Klingon'
        ,false
        ,0.001
);

SELECT *
FROM countrylanguage
WHERE countrycode = 'USA';

-- 2. Add Klingon as a spoken language in Great Britain

SELECT *
FROM countrylanguage
WHERE countrycode = 'GBR'

INSERT INTO countrylanguage
(
        countrycode
        ,language
        ,isofficial
        ,percentage
)
VALUES
(
        'GBR'
        ,'Klingon'
        ,false
        ,0.2
);








INSERT INTO countrylanguage
(
        countrycode
        ,language
        ,isofficial
        ,percentage
)
VALUES ('GBR','Klingon',false,0.2) --an example of adding more than one row at a time
        ,('USA', Esperanto, false, 0.002);

-- UPDATE

--Syntax
/*
UPDATE <table name>
SET <column> = value
        ,<column> = value
WHERE <condition> -- ALWAYS HAVE A WHERE CLAUSE

*/

-- 1. Update the capital of the USA to Houston

--3813 is current capita 3796 is houston (made change, then changed it back to Washington DC)
SELECT *
FROM country
WHERE code = 'USA'

SELECT*
FROM city
WHERE name = 'Houston'

UPDATE country
SET capital = 3796
WHERE code = 'USA';


-- 2. Update the capital of the USA to Washington DC and the head of state
UPDATE country
SET capital = 3813
        ,headofstate = 'Joe Biden'
WHERE code = 'USA';

SELECT *
FROM country
WHERE code = 'USA'

-- DELETE
/*
Syntax
DELETE FROM table_name
WHERE condition;
*/



-- 1. Delete English as a spoken language in the USA
DELETE FROM countrylanguage
WHERE countrycode = 'USA'
        AND language = 'English';

-- 2. Delete all occurrences of the Klingon language 
DELETE FROM countrylanguage
WHERE language = 'Klingon';


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
--

INSERT INTO countrylanguage
(
        countrycode
        ,language
        ,isofficial
        ,percentage
)
VALUES ('USA', 'Elvish', false, 0.002);

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
--ILLEGAL BECAUSE THERE IS NO zzz country in the country table

INSERT INTO countrylanguage
(
        countrycode
        ,language
        ,isofficial
        ,percentage
)
VALUES ('ZZZ', 'English', false, 0.002);

-- 3. Try deleting the country USA. What happens? -- do a select statment first with a where clause so that you grab the correct data
--cannot delete a country that has dependencies on this table 

DELETE FROM country
WHERE code = 'USA'


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
INSERT INTO countrylanguage
(
        countrycode
        ,language
        ,isofficial
        ,percentage
)
VALUES ('USA', 'English', false, 0.002);


-- 2. Try again. What happens? -- FAILS

-- 3. Let's relocate the USA to the continent - 'Outer Space'
--CHECK CONSTRAINT - VALIDATES AGAINST CERTAIN FIELDS IN THE TABLE
UPDATE country
SET continent = 'Outer Space'
WHERE code = 'USA';


-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;


-- TRANSACTIONS

 Begin Transaction;
                UPDATE country
                SET capital = 3796;
--THIS SHOWS ALL UP DATED CAPITALS

                SELECT code
                 ,capital   
FROM country;
--ROLS BACK ANY CHANGES
Rollback Transaction;
--VERIFY THAT NO CAPITALS WERE ACTUALLY UPDATED
SELECT code
        ,capital   
FROM country;

-- 1. Try deleting all of the rows from the country language table and roll it back.
 --CHANGE CAPITAL TO HOUSTON WITHOUT WHERE
 Begin Transaction;
 
        DELETE FROM countrylanguage;
        
        SELECT*
        FROM countrylanguage;
        
Rollback Transaction;
        


-- 2. Try updating all of the cities to be in the USA and roll it back

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.


 Begin Transaction;
 
        UPDATE country
        SET lifeexpectancy = 82.2
        WHERE code = 'USA';
        
Rollback Transaction;
        
        SELECT code
                ,lifeexpectancy
        FROM country
        WHERE code = 'USA';
        
