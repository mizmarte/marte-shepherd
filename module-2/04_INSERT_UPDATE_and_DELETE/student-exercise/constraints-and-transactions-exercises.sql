-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
SELECT*
FROM actor
ORDER BY first_name;

INSERT INTO actor
(       first_name
        ,last_name
)
VALUES ('HAMPTON','AVENUE')
        ,('LISA', 'BYWAY');


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
SELECT *
FROM language;

SELECT*
FROM film
ORDER BY title;

INSERT INTO film
(
        title
        ,description
        ,release_year
        ,language_id
        ,length
)
VALUES ('Euclidean PI','The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198);

UPDATE film
SET title = 'EUCLIDEAN PI'
WHERE film_id = 1001;


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
SELECT*
FROM actor
ORDER BY first_name;
--adding to film_actor table
INSERT INTO film_actor
(
        actor_id
        ,film_id
)
VALUES 
(
        201
        ,1001
);
  SELECT*
  FROM film_actor
  WHERE film_id = 1001; 
       
INSERT INTO film_actor
(
        actor_id
        ,film_id
)
VALUES 
(
        202
        ,1001
);


-- 4. Add Mathmagical to the category table.
INSERT INTO category
(
        name
)
VALUES
(
        'Mathmagical'
);

SELECT*
FROM category;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
SELECT film_id
        ,title
FROM film
WHERE title IN
        ('EUCLIDEAN PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE');

INSERT INTO film_category (film_id,category_id)
VALUES  (1001, 17)
        ,(274, 17)
        ,(494, 17)
        ,(714, 17)
        ,(996, 17);

SELECT *
FROM film_category
WHERE category_id = 17;


-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
BEGIN TRANSACTION;

SELECT rating
FROM film
WHERE title IN 
        ('EUCLIDEAN PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE');
        
UPDATE film
SET rating = 'G'
WHERE title IN 
        ('EUCLIDEAN PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE');

COMMIT TRANSACTION;
        

-- 7. Add a copy of "Euclidean PI" to all the stores.
SELECT store_id
FROM inventory
GROUP BY store_id
ORDER BY store_id DESC;


INSERT INTO inventory 
(
        film_id
        , store_id
)
VALUES (1001, 1)
       ,(1001,2);

      
select film_id
        ,store_id
FROM inventory
WHERE film_id = 1001;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
BEGIN TRANSACTION;
DELETE FROM film
WHERE film_id = 1001;

ROLLBACK TRANSACTION;

-- <YOUR ANSWER HERE> unable to delete on film table because film id is referenced in other tables (film_actor, film_id (PK)) --REFERENTIAL CONSTRAINT--
--VIOLATES FOREIGN KEY CONSTRAINT

-- 9. Delete Mathmagical from the category table.
BEGIN TRANSACTION;

DELETE FROM category
WHERE category_id = 17;

ROLLBACK TRANSACTION;


-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE> Did not succeed.  Category_id is referenced by film_category,(DEPENDENCY) ; foreign key constraint

-- 10. Delete all links to Mathmagical in the film_category tale.
SELECT film_id
FROM film_category
WHERE category_id = 17;

BEGIN TRANSACTION;

DELETE FROM film_category
WHERE film_id IN (1001, 274, 494, 714,996);

ROLLBACK TRANSACTION;



-- (Did it succeed? Why?) 
-- <YOUR ANSWER HERE> - Yes the films were deleted - the film_id is the primary key, and once it's deleted and all data that's linked, 
--this will remove the category_id (which is the foreign key for this table)

-- 11. Retry deleting Mathmagical from the category table, followed by retrying 
-- to delete "Euclidean PI". **SEE ABOVE** deleting the film_id 1001 (Euclidean PI) removed the category and all of its dependencies
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;
