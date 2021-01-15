-- CAMPGROUND TABLE
-----------------------------------------------

-- select name and daily fee of all campgrounds
SELECT name
        , daily_fee
FROM campground;

-- select name and daily fee of all campgrounds ordered by campground name
SELECT name
        , daily_fee
FROM campground
ORDER BY name;

-- select name, open from month, open to month, and daily fee of the campgrounds where daily fee is less than $100
SELECT name
        , open_from_mm
        , open_to_mm
        , daily_fee
FROM campground
WHERE daily_fee < CAST (100 AS MONEY)
ORDER BY name;

-- select name and daily fee of the campgrounds where the campground is open all year long
SELECT name
        ,daily_fee
        ,open_from_mm
        ,open_to_mm
FROM campground
WHERE open_from_mm ='01' AND open_to_mm = '12';



-- PARK TABLE
-----------------------------------------------

-- select name and description of all parks order by established date in descending order
SELECT name
        ,description
        ,establish_date
FROM park
ORDER BY establish_date DESC;

-- select name and description of all parks in Ohio
SELECT name
        ,description
FROM park
WHERE location ilike 'Oh%';

-- select name and description of all parks NOT in Ohio
SELECT name
        ,location
        ,description
        
FROM park
WHERE location != 'Ohio';

-- select the total number of visitors for all parks
SELECT SUM(visitors) AS total_number_of_visitors
FROM park;


-- select the average number of visitors for all parks
SELECT AVG(visitors) AS average_number_of_visitors
FROM park;


-- SITE TABLE
-----------------------------------------------

-- select all columns from site where utilities is true and order by max RV length with the largest coming first
SELECT site_id
        ,campground_id
        ,site_number
        ,max_occupancy
        ,accessible
        ,max_rv_length
FROM site
WHERE utilities = true
ORDER BY max_rv_length DESC;

-- select total number of sites that have utilities hook up

SELECT COUNT (site_id) AS total_number_of_sites_with_utilities_hook_up
FROM site
WHERE utilities = true;



-- RESERVATION TABLE
-----------------------------------------------

-- select reservation id, site id, name, from date, to date of the reservations where the checkin date is between the first and last day of the current month (hard coded month is ok)
SELECT reservation id
        ,site_id
        ,name
        ,from_date
        ,to_date
FROM reservation
WHERE from_date BETWEEN '2021-01-01' AND '2021-01-31';

-- select all columns from reservation where name includes 'Reservation'
SELECT reservation_id
        ,site_id
        ,name
        ,from_date
        ,to_date
        ,create_date
FROM reservation
WHERE name iLIKE '%reserv%';


-- select the total number of reservations in the reservation table
SELECT COUNT (reservation_id) AS total_number_based_on_reservation_id
        ,COUNT(create_date) AS total_number_based_on_reservation_create_date
FROM reservation;

-- select reservation id, site id, name of the reservations where site id is in the list 9, 20, 24, 45, 46
SELECT reservation_id
        ,site_id
        ,name
FROM reservation
WHERE site_id IN
        (
                9, 20, 24, 45, 46
        );

-- select the date and number of reservations for each date orderd by from_date in ascending order

SELECT from_date AS date_of_reservations
        ,COUNT(create_date) AS number_of_reservations
FROM reservation
GROUP BY from_date
ORDER BY from_date;

