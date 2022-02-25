BEGIN TRANSACTION;

DROP TABLE IF EXISTS subtask, category, task;

CREATE TABLE category (
	id SERIAL PRIMARY KEY,
	name VARCHAR(256) NOT NULL
);

CREATE TABLE task (
	id SERIAL PRIMARY KEY,
	description varchar(256) NOT NULL,
	created DATE DEFAULT CURRENT_DATE,
	due DATE,
	complete BOOLEAN DEFAULT FALSE,
	category_id INT NOT NULL REFERENCES category
);

CREATE TABLE subtask (
	id SERIAL PRIMARY KEY,
	task_id INT NOT NULL REFERENCES task ON DELETE CASCADE,
	description VARCHAR(256) NOT NULL,
	complete BOOLEAN DEFAULT FALSE
);

INSERT INTO category (name) VALUES 
('Category 1'),
('Category 2');

INSERT INTO task (description, created, due, complete, category_id) VALUES 
('Task 1', '2020-02-15', '2020-02-20', false, 1),
('Task 2', '2020-02-17', null, false, 1),
('Task 3', '2020-02-10', null, true, 1),
('Task 4', '2020-02-10', '2020-02-12', false, 2);

INSERT INTO subtask (description, complete, task_id) VALUES 
('Task 1 - Subtask 1', false, 1),
('Task 1 - Subtask 2', false, 1),
('Task 1 - Subtask 3', false, 1),
('Task 2 - Subtask 1', true, 2);

COMMIT;
