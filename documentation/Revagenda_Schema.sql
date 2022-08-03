CREATE TABLE users (
	user_id SERIAL, /*This is the self-incrementing data type in postgresql. Some other SQL flavors will implement this functionality differently*/
	user_name VARCHAR(200) NOT NULL,
	email VARCHAR(200) NOT NULL,
	"password" VARCHAR(200) NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (user_id) /*We could also simply put "PRIMARY KEY" on the user_id definition*/
);


CREATE TABLE tasks (
	task_id SERIAL PRIMARY KEY,
	title VARCHAR(60) NOT NULL,
	message VARCHAR(2000),
	user_id INT,
	completed BOOL,
	CONSTRAINT tasks_users_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);
