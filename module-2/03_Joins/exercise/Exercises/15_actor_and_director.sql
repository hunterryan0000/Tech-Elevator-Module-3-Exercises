-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
select title, person_name from movie
join movie_actor on movie.movie_id = movie_actor.movie_id
join person on movie_actor.actor_id = person.person_id
where person_id = director_id;
