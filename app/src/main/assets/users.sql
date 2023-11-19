--
-- File generated with SQLiteStudio v3.4.4 on ѕн но€ 20 01:50:48 2023
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: users
CREATE TABLE IF NOT EXISTS users (
    name     STRING  NOT NULL,
    login    STRING  NOT NULL,
    password STRING  NOT NULL,
    isadmin  BOOLEAN NOT NULL
                     DEFAULT (false) 
);

INSERT INTO users (
                      name,
                      login,
                      password,
                      isadmin
                  )
                  VALUES (
                      'head admin',
                      'test',
                      'test',
                      1
                  );

INSERT INTO users (
                      name,
                      login,
                      password,
                      isadmin
                  )
                  VALUES (
                      'head admin',
                      'danilka',
                      1234,
                      1
                  );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
