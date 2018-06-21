-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)

select film.title from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
Where first_name = 'NICK' and last_name = 'STALLONE'


-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)

select film.title from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
Where first_name = 'RITA' and last_name = 'REYNOLDS'

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)

select film.title from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
Where (first_name = 'JUDY' or first_name = 'RIVER') and last_name = 'DEAN'

-- 4. All of the the ‘Documentary’ films
-- (68 rows)

select film.title from film
join film_category fc on fc.film_id = film.film_id
join category c on c.category_id = fc.category_id
where c.name = 'Documentary'

-- 5. All of the ‘Comedy’ films
-- (58 rows)

select film.title from film
join film_category fc on fc.film_id = film.film_id
join category c on c.category_id = fc.category_id
where c.name = 'Comedy'

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)

select film.title from film
join film_category fc on fc.film_id = film.film_id
join category c on c.category_id = fc.category_id
where c.name = 'Children' and rating = 'G';

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)

select film.title from film
join film_category fc on fc.film_id = film.film_id
join category c on c.category_id = fc.category_id
where c.name = 'Family' and rating = 'G' and length < 120;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)

select film.title from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
Where first_name = 'MATTHEW' and last_name = 'LEIGH' and rating = 'G'

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)

select film.title from film
join film_category fc on fc.film_id = film.film_id
join category c on c.category_id = fc.category_id
where c.name = 'Sci-Fi' and release_year = 2006;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)

select film.title from film
join film_category fc on fc.film_id = film.film_id
join category c on c.category_id = fc.category_id
join film_actor on film.film_id = film_actor.film_id
join actor on film_actor.actor_id = actor.actor_id
where c.name = 'Action' and first_name = 'NICK' and last_name = 'STALLONE'

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)

select address, city, district, country from address
join city on address.city_id = city.city_id
join country on city.country_id = country.country_id
join store on store.address_id = address.address_id

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)

select store.store_id, address, first_name, last_name from store
join address on store.address_id = address.address_id
join staff on staff.staff_id = store.manager_staff_id

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)

select count(*) as rentals, first_name, last_name from rental
join customer on customer.customer_id = rental.customer_id
group by last_name, first_name
order by rentals desc

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)

select sum(amount) as amount_spent, first_name, last_name from rental
join customer on customer.customer_id = rental.customer_id
join payment on rental.rental_id = payment.rental_id
group by last_name, first_name
order by amount_spent desc

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

select store.store_id, address, count(rental.rental_id) as number_of_rentals, sum(amount) as amount_of_sales, round(avg(amount), 2) as average_sale
from store
join inventory on inventory.store_id = store.store_id
join rental on inventory.inventory_id = rental.inventory_id
join payment on payment.rental_id = rental.rental_id
join address on store.address_id = address.address_id
group by store.store_id, address

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)

select title, count(rental_id) as number_of_rentals from inventory
join film on inventory.film_id = film.film_id
join rental on rental.inventory_id = inventory.inventory_id
group by title
order by number_of_rentals desc
limit 10

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)

select category.name, count(rental.rental_id) as rental_count
from film
join inventory on film.film_id=inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id 
join film_category on film.film_id = film_category.film_id
join category on film_category.category_id = category.category_id
group by category.name
order by rental_count desc
limit 5

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)

select film.title, count(rental.rental_id) as rental_count
from film
join inventory on film.film_id=inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id 
join film_category on film.film_id = film_category.film_id
join category on film_category.category_id = category.category_id
where category.name = 'Action'
group by film.title
order by rental_count desc
limit 5

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)

--** NOT WORKING as targeted ** --> have susan davis with 825 rentals at #1 --> John looked at this with me
select first_name, last_name, count(rental.rental_id) as rental_count
from actor
join film_actor on film_actor.actor_id = actor.actor_id
join film on film_actor.film_id = film.film_id
join inventory on inventory.film_id = film.film_id 
join rental on inventory.inventory_id = rental.inventory_id
group by last_name, first_name
order by rental_count desc
limit 10

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)

select first_name, last_name, count(rental.rental_id) as rental_count
from film
join inventory on film.film_id=inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id 
join film_category on film.film_id = film_category.film_id
join category on film_category.category_id = category.category_id
join film_actor on film.film_id = film_actor.film_id
join actor on film_actor.actor_id = actor.actor_id
where category.name = 'Comedy'
group by last_name, first_name
order by rental_count desc
limit 5
