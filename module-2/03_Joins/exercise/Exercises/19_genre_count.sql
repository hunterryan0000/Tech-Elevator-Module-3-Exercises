-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).
select genre_name, Count (*) as num_of_movies from movie
join movie_genre on movie.movie_id = movie_genre.movie_id
join genre on movie_genre.genre_id = genre.genre_id
group by genre_name;
