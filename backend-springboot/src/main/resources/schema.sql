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
    VALUES ('Analizis', 'Online', 'Molnar Gabor Marcell', '2023-03-12', 20, 20);

INSERT INTO examList (examName, examLocation, lecturer, examDate, examLimit, examFreeSpace)  
    VALUES ('Halozati architecturak', 'D.Ker. 6.', 'Dr. Szabo Istvan', '2023-05-10', 15, 15);

INSERT INTO examList (examName, examLocation, lecturer, examDate, examLimit, examFreeSpace)  
    VALUES ('Hatekony feljegyzes', 'Online', 'Losonczi Peter', '2023-04-13', 100, 100);

INSERT INTO examList (examName, examLocation, lecturer, examDate, examLimit, examFreeSpace)  
    VALUES ('Operaciokutatas', 'B.I.182.', 'Grunwald Richard', '2023-11-20', 12, 12);

INSERT INTO examList (examName, examLocation, lecturer, examDate, examLimit, examFreeSpace)  
    VALUES ('Rendszerfejlesztes', 'Online', 'Vegera Jozsef', '2023-10-27', 50, 50);

INSERT INTO examList (examName, examLocation, lecturer, examDate, examLimit, examFreeSpace)  
    VALUES ('Rendszerkozeli Programozas', 'Online', 'Dr. Kerenyi Gabor', '2023-06-30', 24, 24);

INSERT INTO examList (examName, examLocation, lecturer, examDate, examLimit, examFreeSpace)  
    VALUES ('Programozasi Technologiak', 'Online', 'Valyi Sandor Zoltan', '2023-11-20', 30, 30);


CREATE TABLE studentRegistration (
    id IDENTITY NOT NULL,
    studentName VARCHAR(255) NOT NULL,
    registeredTo VARCHAR(255) NOT NULL
);