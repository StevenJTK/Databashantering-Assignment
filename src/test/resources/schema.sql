CREATE TABLE IF NOT EXISTS work_role (
    role_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    title VARCHAR(50),
    description VARCHAR(50)
    salary DOUBLE,
    creation_date DATE,
    PRIMARY KEY (role_id);
)