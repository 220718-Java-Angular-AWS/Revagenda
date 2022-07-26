CREATE TABLE users (
	user_id SERIAL,
	username VARCHAR(200) NOT NULL UNIQUE,
	email VARCHAR(200) NOT NULL,
	"password" VARCHAR(200) NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (user_id)
	);


CREATE TABLE tasks (
	task_id SERIAL PRIMARY KEY,
	title VARCHAR(60) NOT NULL,
	message VARCHAR(2000),
	user_id INT,
	completed BOOL,
	CONSTRAINT tasks_users_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
    );
