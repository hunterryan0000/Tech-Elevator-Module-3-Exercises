BEGIN;

DROP TABLE IF EXISTS post, friend, app_user;

CREATE TABLE app_user (
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	password_hash VARCHAR(200) NOT NULL
);

CREATE TABLE friend (
	id SERIAL PRIMARY KEY,
	user1_id int NOT NULL REFERENCES app_user,
	user2_id int NOT NULL REFERENCES app_user
);

CREATE TABLE post (
	id SERIAL PRIMARY KEY,
	user_id int NOT NULL REFERENCES app_user,
	title VARCHAR(100) NOT NULL,
	text VARCHAR(500) NOT NULL,
	create_date TIMESTAMP DEFAULT NOW()
);

INSERT INTO app_user (username, password_hash)
VALUES -- Password is the same as the username
	('OrangeCatKyo', '$2a$10$29L346Y.NnPqTJ3j9SLT2ufaZ89dDahYieNbmIUV24nlqVSSX585O'),
	('AbbyChan', '$2a$10$KOV7mPvtMg9CUd1f1cZNsuGJ.hLX3.OTDOK/LTS65fvfjBfD/lP7C'),
	('CatwalkFred', '$2a$10$pT.ht9f4YjTAVDUgV.3/gOj.msgThVQMaLV4s1prsw2GXxHBOQQB2'),
	('ProfessorTrouble', '$2a$10$bBwIcw.mrutSQe.4ncUmSuy7vHAN4tcCCDs03vbhnqj1CUbjwtQqK');

INSERT INTO friend (user1_id, user2_id)
VALUES
	((SELECT id FROM app_user WHERE username='AbbyChan'), (SELECT id FROM app_user WHERE username='OrangeCatKyo')),
	((SELECT id FROM app_user WHERE username='ProfessorTrouble'), (SELECT id FROM app_user WHERE username='OrangeCatKyo')),
	((SELECT id FROM app_user WHERE username='ProfessorTrouble'), (SELECT id FROM app_user WHERE username='CatwalkFred')),
	((SELECT id FROM app_user WHERE username='CatwalkFred'), (SELECT id FROM app_user WHERE username='OrangeCatKyo'));

INSERT INTO post (user_id, title, text, create_date)
VALUES
	((SELECT id FROM app_user WHERE username='AbbyChan'), 'Day in the Sun', 'Wow! The sunshine was awesome today! Loved the way it warmed the floor, but didn''t appreciate having to move every hour as it moved.', '2021-12-02 20:15:52'),
	((SELECT id FROM app_user WHERE username='OrangeCatKyo'), 'Just Chillin''', 'Awesome day today. Didn''t really do much. Just spent the day chillin'' in the cat hammock.', '2021-12-02 20:35:40'),
	((SELECT id FROM app_user WHERE username='ProfessorTrouble'), 'Got to Play Ball!', 'Found a new toy today! It was so much fun to nose it around the floor, but the people didn''t seem to like it when it fell down the stairs. I brought it back up several times, so I can''t imagine what the problem was?!', '2021-11-20 16:45:22'),
	((SELECT id FROM app_user WHERE username='AbbyChan'), 'Prowler alert!', 'Was on alert all day today after an intruder dare to park themselves outside my window for the morning. I finally managed to run them off, but stayed alert all afternoon... Well until I fell asleep. Guard duty is tiring!', '2022-01-01 20:11:32'),
	((SELECT id FROM app_user WHERE username='CatwalkFred'), 'Stranger on the Block', 'Had some new cat hanging out on the back porch today. Didn''t introduce themselves or anything. Totally ignored us here. Abby was NOT HAPPY and took it out on me. Really? What did I do?!', '2022-01-01 18:18:02');


COMMIT;

