-- CREATE DATABASE
CREATE DATABASE School;
USE School;

-- CREATE TABLE
CREATE TABLE Student (
    Id int NOT NULL,
    FirstName varchar(255) NOT NULL,
    LastName varchar(255) NOT NULL,
    Age int,
    PRIMARY KEY (Id)
);

-- CREATE DATA
INSERT INTO Student VALUES (
    1, 'David', 'Lopez', 18
);

INSERT INTO Student VALUES (
    2, 'Sergio', 'Ruiz', 19
);

INSERT INTO Student VALUES (
    3, 'Andres', 'Huerta', 19
);