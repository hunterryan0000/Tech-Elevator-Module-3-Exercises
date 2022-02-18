-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)
select distinct person_name, birthday from person
join movie_actor on person.person_id = movie_actor.actor_id
join movie on movie_actor.movie_id = movie.movie_id
where birthday > '01/01/1950' and birthday < '12/31/1959'
AND release_date > '01/01/1985' and release_date < '12/31/1985';
