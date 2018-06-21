-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

select * from actor
insert into actor (first_name, last_name) values ('HAMPTON', 'AVENUE')
insert into actor (first_name, last_name) values ('LISA', 'BYWAY')

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.	


select * from film
order by film_id desc
insert into film (film_id, title, description, release_year, language_id, length) values (1001, 'Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198)

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
Start Transaction
rollback
commit

select * from actor
select * from film_actor where film_id = 1001

insert into film_actor (film_id, actor_id) values ((select film_id from film where title = 'Euclidean PI'), (select actor_id from actor where first_name = 'HAMPTON' and last_name = 'AVENUE'))
insert into film_actor (film_id, actor_id) values ((select film_id from film where title = 'Euclidean PI'), (select actor_id from actor where first_name = 'LISA' and last_name = 'BYWAY'))



-- 4. Add Mathmagical to the category table.
select * from category
insert into category (name) values ('Mathmagical')

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
select * from film_category where category_id = (select category_id from category where name = 'Mathmagical')

insert into film_category (film_id, category_id) values ((select film_id from film where title = 'Euclidean PI'), (select category_id from category where name = 'Mathmagical'))
insert into film_category (film_id, category_id) values ((select film_id from film where title = 'EGG IGBY'), (select category_id from category where name = 'Mathmagical'))
insert into film_category (film_id, category_id) values ((select film_id from film where title = 'KARATE MOON'), (select category_id from category where name = 'Mathmagical'))
insert into film_category (film_id, category_id) values ((select film_id from film where title = 'RANDOM GO'), (select category_id from category where name = 'Mathmagical'))
insert into film_category (film_id, category_id) values ((select film_id from film where title = 'YOUNG LANGUAGE'), (select category_id from category where name = 'Mathmagical'))

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)
select rating from film where film_id in (
                                        select film_id from film_category where category_id = (select category_id from category where name = 'Mathmagical')
                                         )

update film set rating = 'G' 
where film_id in (
        select film_id from film_category where category_id = (select category_id from category where name = 'Mathmagical')
        )
        
-- 7. Add a copy of "Euclidean PI" to all the stores.
select * from inventory where film_id = (select film_id from film where title = 'Euclidean PI')
select * from store

insert into inventory (film_id, store_id) values ((select film_id from film where title = 'Euclidean PI'), 1);
insert into inventory (film_id, store_id) values ((select film_id from film where title = 'Euclidean PI'), 2);


-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)
start transaction
rollback
commit

select * from film where title = 'Euclidean PI'
delete from film where title = 'Euclidean PI'
-- *** did not succeed because the film_id in this entry is used as a foreign key in the film_category table


-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)
start transaction
rollback
commit

select * from category where name = 'Mathmagical'
delete from category where name = 'Mathmagical'
-- *** did not succeed because the category_id in this entry is used as a foreign key in the film_category table


-- 10. Delete all links to Mathmagical in the film_category table. 
-- (Did it succeed? Why?)
select * from film_category where category_id = (select category_id from category where name = 'Mathmagical')
Delete from film_category where category_id = (select category_id from category where name = 'Mathmagical')
-- *** it was successful because the values of these rows were not being used as foreign keys in any other tables

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)
delete from film where title = 'Euclidean PI'
delete from category where name = 'Mathmagical'
-- ** mathmagical was deleted successfully but Euclidean PI was not. This is becase the film_id for Euclidean PI is still being used as a foreign key in the inventory and film_actor tables.

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

-- **all entries with the Euclidean PI film_id need to be deleted from the film_actor and inventory tables before the film can be deleted from the film table. 

