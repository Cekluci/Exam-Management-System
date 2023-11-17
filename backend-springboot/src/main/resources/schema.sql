CREATE TABLE examList (
    id IDENTITY NOT NULL,
    examName VARCHAR(255) NOT NULL,
    examLocation VARCHAR(255) NOT NULL,
    lecturer VARCHAR(255) NOT NULL,
    examDate DATE NOT NULL,
    examLimit INT NOT NULL,
    examFreeSpace INT NOT NULL
);

INSERT INTO examList (examName, examLocation, lecturer, examDate, examLimit, examFreeSpace)
    VALUES ('Rendszerfejlesztes', 'Online', 'John Doe', '2023-03-12', 20, 20);