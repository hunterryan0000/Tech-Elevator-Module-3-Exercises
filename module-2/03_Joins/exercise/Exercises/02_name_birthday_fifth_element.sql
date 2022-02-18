-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
select person_name, birthday from person
join movie_actor on person.person_id = movie_actor.actor_id
join movie on movie_actor.movie_id = movie.movie_id
where title = 'The Fifth Element';

