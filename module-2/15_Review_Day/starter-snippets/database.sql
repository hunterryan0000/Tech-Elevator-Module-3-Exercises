BEGIN;

DROP TABLE IF EXISTS post;

CREATE TABLE post (
	id SERIAL PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	text VARCHAR(500) NOT NULL,
	create_date TIMESTAMP DEFAULT NOW()
);

INSERT INTO post (title, text, create_date) 
VALUES 
	('Day in the Sun', 'Wow! The sunshine was awesome today! Loved the way it warmed the floor, but didn''t appreciate having to move every hour as it moved.', '2021-12-02 20:15:52'),
	('Got to Play Ball!', 'Found a new toy today! It was so much fun to nose it around the floor, but the people didn''t seem to like it when it fell down the stairs. I brought it back up several times, so I can''t imagine what the problem was?!', '2021-11-20 16:45:22'),
	('Stranger on the Block', 'Was on alert all day today after an intruder dare to park themselves outside my window for the morning. I finally managed to run them off, but stayed alert all afternoon... Well until I fell asleep. Guard duty is tiring!', '2022-01-01 18:18:02');
	
COMMIT;