-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet.
--Add yourself to the person table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)
insert into person (person_name)
values ('Ryan Hunter');
update movie set director_id = (select person_id from person where person_name = 'Ryan Hunter')
where movie_id = '367220';
