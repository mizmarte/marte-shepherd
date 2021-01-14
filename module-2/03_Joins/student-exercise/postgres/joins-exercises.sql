-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT f.title AS All_films_that_Nick_Stallone_has_appeared_in
FROM film AS f
INNER JOIN film_actor AS fa
ON f.film_id = fa.film_id
INNER JOIN actor AS a
ON a.actor_id = fa.actor_id
WHERE a.first_name = 'NICK' AND a.last_name = 'STALLONE';


-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)

SELECT f.title AS All_films_that_Rita_Reynolds_has_appeared_in
FROM film AS f
INNER JOIN film_actor AS fa
ON f.film_id = fa.film_id
INNER JOIN actor AS a
ON a.actor_id = fa.actor_id
WHERE a.first_name = 'RITA' AND a.last_name = 'REYNOLDS';

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)

SELECT f.title AS All_films_that_Judy_Dean_or_River_Dean_have_appeared_in
FROM film AS f
INNER JOIN film_actor AS fa
ON f.film_id = fa.film_id
INNER JOIN actor AS a
ON a.actor_id = fa.actor_id
WHERE a.last_name = 'DEAN';



-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT f.*
       ,f.title
FROM film AS f
INNER JOIN film_category AS fc
ON f.film_id = fc.film_id
INNER JOIN category AS c
ON fc.category_id = c.category_id
WHERE c.name = 'Documentary';



-- 5. All of the ‘Comedy’ films
-- (58 rows)

SELECT f.*
       ,f.title
FROM film AS f
INNER JOIN film_category AS fc
ON f.film_id = fc.film_id
INNER JOIN category AS c
ON fc.category_id = c.category_id
WHERE c.name = 'Comedy';



-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)

SELECT f.*
       ,f.title
       ,f.rating
FROM film AS f
INNER JOIN film_category AS fc
ON f.film_id = fc.film_id
INNER JOIN category AS c
ON fc.category_id = c.category_id
WHERE c.name = 'Children' AND f.rating = 'G';


-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)

SELECT f.*
        ,f.rating
       ,f.title
       ,f.length
FROM film AS f
INNER JOIN film_category AS fc
ON f.film_id = fc.film_id
INNER JOIN category AS c
ON fc.category_id = c.category_id
WHERE c.name = 'Family' 
        AND f.length < 120
        AND f.rating = 'G';

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT f.*
        ,f.rating
       ,f.title
FROM film AS f
INNER JOIN film_category AS fc
ON f.film_id = fc.film_id
INNER JOIN category AS c
ON fc.category_id = c.category_id
INNER JOIN film_actor AS fa
ON f.film_id = fa.film_id
INNER JOIN actor AS a
ON a.actor_id = fa.actor_id
WHERE a.first_name = 'MATTHEW' 
        AND a.last_name = 'LEIGH'
        AND f.rating = 'G';


-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)

SELECT f.*
        ,f.release_year
       ,f.title
FROM film AS f
INNER JOIN film_category AS fc
ON f.film_id = fc.film_id
INNER JOIN category AS c
ON fc.category_id = c.category_id
WHERE c.name = 'Sci-Fi' 
        AND f.release_year = '2006'
 

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)

SELECT f.*
       ,f.title
FROM film AS f
INNER JOIN film_category AS fc
ON f.film_id = fc.film_id
INNER JOIN category AS c
ON fc.category_id = c.category_id
INNER JOIN film_actor AS fa
ON f.film_id = fa.film_id
INNER JOIN actor AS a
ON a.actor_id = fa.actor_id
WHERE a.first_name = 'NICK' 
        AND a.last_name = 'STALLONE'
        AND c.name = 'Action';



-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT 
        a.address
        ,a.address2
        ,a.district
        ,a.city_id
        ,a.postal_code
        ,cu.country
    
FROM store AS S
INNER JOIN address AS a
ON s.address_id = a.address_id
INNER JOIN city AS c
ON c.city_id = a.city_id
INNER JOIN country AS cu
ON cu.country_id = c.country_id




-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT 
        s.store_id
        ,st.first_name
        ,st.last_name
        ,a.address
        ,a.address2
        ,a.district
        ,a.city_id
        ,a.postal_code
        ,cu.country
    
FROM store AS s
INNER JOIN address AS a
ON s.address_id = a.address_id
INNER JOIN city AS c
ON c.city_id = a.city_id
INNER JOIN country AS cu
ON cu.country_id = c.country_id
INNER JOIN staff AS st
ON st.staff_id = s.manager_staff_id

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT�? with 46 rentals, #10 should have 39 rentals)

SELECT c.first_name
        ,c.last_name
        ,COUNT(r.rental_id)
FROM customer AS c
INNER JOIN rental AS r
ON c.customer_id = r.customer_id
GROUP BY(c.first_name, c.last_name)
ORDER BY COUNT(r.rental_id) DESC
LIMIT 10 

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL�? with 221.55 spent, #10 should be “ANA BRADLEY�? with 174.66 spent)

SELECT c.first_name
        ,c.last_name
        ,SUM(p.amount) AS Dollars_spent
FROM customer AS c
INNER JOIN payment AS p
ON c.customer_id = p.customer_id
GROUP BY(c.first_name, c.last_name)
ORDER BY SUM(p.amount) DESC, c.last_name DESC
LIMIT 10; 

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

SELECT s.store_id --my query
        ,a.address
        ,COUNT(r.rental_id) AS Total_number_of_rentals
       ,SUM(p.amount) AS Total_amount_of_sales
       ,AVG(p.amount) AS Average_amount_of_sales
FROM store AS s
INNER JOIN address AS a
ON s.address_id = a.address_id
INNER JOIN customer AS c
ON s.store_id = c.store_id
INNER JOIN rental AS r
ON r.customer_id = c.customer_id
INNER JOIN payment AS p
ON p.customer_id = r.customer_id
GROUP BY (s.store_id, a.address)
--ORDER BY Total_number_of_rentals;

SELECT s.store_id --the correct query
        ,a.address
        ,COUNT (i.inventory_id) AS inventory_count
        ,COUNT(r.rental_id) AS rental_count
        ,SUM(amount) AS total_sales
        ,AVG(amount) AS average_sales
FROM store AS s
INNER JOIN address AS a
ON s.address_id = a.address_id
INNER JOIN inventory AS i
        ON s.store_id = i.store_id
INNER JOIN rental AS r
        ON i.inventory_id = r.inventory_id
INNER JOIN payment AS p
        ON r.rental_id = p.rental_id
--WHERE S.store_id = 1
group by s.store_id
        ,a.address
;


-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD�? with 34 rentals and #10 should have 31 rentals)

SELECT f.title AS Top_10_film_titles
        
        ,COUNT(r.rental_id)
FROM FILM AS f
INNER JOIN inventory AS i
ON f.film_id = i.film_id
INNER JOIN rental AS r
ON r.inventory_id = i.inventory_id
GROUP BY(f.title)
ORDER BY COUNT(r.rental_id) DESC
LIMIT 10 

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports�? with 1179 rentals and #5 should be “Family�? with 1096 rentals)
SELECT c.name AS Top_5_film_categories
        
        ,COUNT(r.rental_id)
FROM category AS c
INNER JOIN film_category AS fc
ON fc.category_id = c.category_id
INNER JOIN film AS f
ON f.film_id = fc.film_id
INNER JOIN inventory AS i
ON f.film_id = i.film_id
INNER JOIN rental AS r
ON r.inventory_id = i.inventory_id
GROUP BY(c.name)
ORDER BY COUNT(r.rental_id) DESC
LIMIT 5 


-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT f.title AS Top_5_film_titles
        
        ,COUNT(r.rental_id)
FROM category AS c
INNER JOIN film_category AS fc
ON fc.category_id = c.category_id
INNER JOIN film AS f
ON f.film_id = fc.film_id
INNER JOIN inventory AS i
ON f.film_id = i.film_id
INNER JOIN rental AS r
ON r.inventory_id = i.inventory_id
WHERE c.name = 'Action'
GROUP BY(f.title)
ORDER BY COUNT(r.rental_id) DESC
LIMIT 5 



-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES�? with 753 rentals and #10 should be “SEAN GUINESS�? with 599 rentals)

SELECT a.first_name
        ,a.last_name
        ,COUNT(r.rental_id)
FROM actor AS a
INNER JOIN film_actor AS fa
ON fa.actor_id = a.actor_id
INNER JOIN film AS f
ON f.film_id = fa.film_id
INNER JOIN inventory AS i
ON f.film_id = i.film_id
INNER JOIN rental AS r
ON r.inventory_id = i.inventory_id
GROUP BY a.first_name, a.last_name, a.actor_id
ORDER BY COUNT(r.rental_id) DESC
LIMIT 10;



-- 20. The top 5 “Comedy�? actors ranked by number of rentals of films in the “Comedy�? category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)

SELECT a.first_name
        ,a.last_name
        ,COUNT(r.rental_id)
FROM actor AS a
INNER JOIN film_actor AS fa
ON fa.actor_id = a.actor_id
INNER JOIN film AS f
ON f.film_id = fa.film_id
INNER JOIN inventory AS i
ON f.film_id = i.film_id
INNER JOIN rental AS r
ON r.inventory_id = i.inventory_id
INNER JOIN film_category AS fc
ON fc.film_id = f.film_id
INNER JOIN category AS c
ON c.category_id = fc.category_id
WHERE c.name = 'Comedy'
GROUP BY a.first_name, a.last_name, a.actor_id
ORDER BY COUNT(r.rental_id) DESC
LIMIT 5;
