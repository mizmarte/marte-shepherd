-- select the park name, campground name, open_from_mm, open_to_mm & daily_fee ordered by park name and then campground name
SELECT p.name AS park_name
        , c.name AS campground_name
        , open_from_mm
        ,open_to_mm
        ,daily_fee
FROM park AS p
INNER JOIN campground AS C
        ON c.park_id = p.park_id
ORDER BY park_name
        , campground_name;



-- select the park name and the total number of campgrounds for each park ordered by park name
SELECT p.name AS park_name
        ,COUNT (c.campground_id) AS total_number_of_campgrounds
      
FROM park AS p
INNER JOIN campground AS C
        ON c.park_id = p.park_id
GROUP BY park_name
ORDER BY park_name;


-- select the park name, campground name, site number, max occupancy, accessible, max rv length, utilities where the campground name is 'Blackwoods'
SELECT p.name AS park_name
        , c.name AS campground_name
        , s.site_number
        , s.max_occupancy
        , s.accessible
        , s.max_rv_length
        , s.utilities
FROM park AS p
INNER JOIN campground AS C
        ON c.park_id = p.park_id
INNER JOIN site AS s
        ON s.campground_id = c.campground_id
WHERE c.name ILIKE 'black%';
        




/*
  select park name, campground, total number of sites (column alias 'number_of_sites') ordered by park
  -------------------------------------------------
    Acadia	Blackwoods	276
    Acadia	Seawall	198
    Acadia	Schoodic Woods	92
    Arches	"Devil's Garden"	49
    Arches	Canyon Wren Group Site	1
    Arches	Juniper Group Site	1
    Cuyahoga Valley	The Unnamed Primitive Campsites	5
  -------------------------------------------------
*/

SELECT p.name AS park_name
        , c.name AS campground_name
        , COUNT (s.site_id) AS number_of_sites
FROM park AS p
INNER JOIN campground AS C
        ON c.park_id = p.park_id
INNER JOIN site AS s
        ON s.campground_id = c.campground_id
GROUP BY park_name
        , campground_name
ORDER BY park_name;




-- select site number, reservation name, reservation from and to date ordered by reservation from date
SELECT s.site_number
        , r.name AS reservation_name
        , r.from_date AS reservation_from_date
        , r.to_date AS reservation_to_date
FROM site AS s
INNER JOIN reservation AS r
ON r.site_id = s.site_id
ORDER BY reservation_from_date;


/*
  select campground name, total number of reservations for each campground ordered by total reservations desc
  -------------------------------------------------
    Seawall	13
    Blackwoods	9
    "Devil's Garden"	7
    Schoodic Woods	7
    The Unnamed Primitive Campsites	5
    Canyon Wren Group Site	4
    Juniper Group Site	4
  -------------------------------------------------
*/

SELECT c.name AS campground_name
        ,COUNT (r.reservation_id) AS total_number_reservations
FROM campground AS c
INNER JOIN site AS s
        ON s.campground_id = c.campground_id
INNER JOIN reservation AS r
ON r.site_id = s.site_id
GROUP BY campground_name
ORDER BY total_number_reservations DESC;


