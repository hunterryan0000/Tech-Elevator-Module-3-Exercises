-- 9. The titles of movies directed by James Cameron (6 rows)
--select title from movie
--where director_id = '2710'

select title from person
join movie on person.person_id = movie.director_id
where person_name = 'James Cameron'
