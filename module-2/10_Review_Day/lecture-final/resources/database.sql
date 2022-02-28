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
('Chores'),
('School'),
('Personal'),
('Work');

INSERT INTO task (description, created, due, complete, category_id) VALUES 
('Get groceries', current_date - 3, current_date + 4, false, (SELECT category.id FROM category WHERE name = 'Chores')),
('Do laundry', current_date, current_date + 3, false, (SELECT category.id FROM category WHERE name = 'Chores')),
('Do homework', current_date - 1, current_date, false, (SELECT category.id FROM category WHERE name = 'School')),
('Update Blog', current_date, NULL, false, (SELECT category.id FROM category WHERE name = 'Personal')),
('Ice-Cream Date!', current_date - 4, current_date - 3, true, (SELECT category.id FROM category WHERE name = 'Personal'));

INSERT INTO subtask (description, complete, task_id) VALUES 
('Eggs', false, (SELECT task.id FROM task WHERE description = 'Get groceries')),
('Bread', false, (SELECT task.id FROM task WHERE description = 'Get groceries')),
('Ice-Cream', false, (SELECT task.id FROM task WHERE description = 'Get groceries'));

COMMIT;
