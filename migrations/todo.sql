CREATE TABLE todos (
    id INTEGER NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE todo_costs (
    id INTEGER NOT NULL,
    todo_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (todo_id)
        REFERENCES todos(id)
);

/*
CREATE TABLE todos (
    id INTEGER NOT NULL,
    description VARCHAR(1024) NOT NULL,
    cost int,
    PRIMARY KEY (id)
);
*/
