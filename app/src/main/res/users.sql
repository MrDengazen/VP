--
-- File generated with SQLiteStudio v3.4.4 on Вс ноя 19 23:26:00 2023
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Info
CREATE TABLE IF NOT EXISTS Info (name STRING NOT NULL, login STRING NOT NULL, password STRING NOT NULL, isadmin BOOLEAN NOT NULL DEFAULT (false));
INSERT INTO Info (name, login, password, isadmin) VALUES ('head admin', 'test', 'test', 1);
INSERT INTO Info (name, login, password, isadmin) VALUES ('head admin', 'danilka', 1234, 1);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
