-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)
select title from movie
join collection on movie.collection_id = collection.collection_id
where collection_name = 'Star Wars Collection'
and director_id != 1;
