\c postgres

DROP DATABASE vehicule;

CREATE DATABASE vehicule; 

\c vehicule

CREATE TABLE vehicule
(
	id serial primary key,
	marque varchar(50),
	model varchar(50),
	couleur varchar(50),
	km int
);

INSERT INTO vehicule
(marque, model, couleur, km)
VALUES
('Toyota','Fortuner','Gris',100000),
('Audi','Q7','Noir',200000),
('Renault','R5','Rouge',300000),
('Mercedes','Amg','Vert',400000),
('Suzuki','Vitara','Bleu',500000);

CREATE TABLE kilometrage
(
	id serial primary key,
	idvehicule varchar(50),
	date date,
	debut_km int,
	fin_km int
);

INSERT INTO kilometrage
(idvehicule, date, debut_km, fin_km)
VALUES
(2,'10-01-2022',100000,150000),
(3,'10-02-2022',200000,250000),
(4,'10-03-2022',300000,350000),
(5,'10-04-2022',400000,450000),
(7,'10-05-2022',500000,550000);

CREATE TABLE utilisateur
(
	id serial primary key,
	name varchar(50),
	username varchar(50),
	email varchar(50),
	password varchar(50)
);

INSERT INTO utilisateur
(name, username, email, password)
VALUES
('Rakoto Ny Fitia','fitia','fitia@gmail.com','fitiamdp'),
('Randia Nary','nary','nary@gmail.com','narymdp'),
('Andria Amy ','amy','amy@gmail.com','amymdp'),
('Rabe Lahatra','lahatra','lahatra@gmail.com','lahatramdp'),
('Razana Ando','ando','ando@gmail.com','andomdp');


\c postgres

DROP DATABASE mine;

CREATE DATABASE mine;

\c mine;

CREATE TABLE terrain 
(
    id serial primary key,
    pointDroiteHautX int,
    pointDroiteHautY int,
    pointDroiteBasX int,
    pointDroiteBasY int,
    pointGaucheHautX int,
    pointGaucheHautY int,
    pointGaucheBasX int,
    pointGaucheBasY int,
    area Decimal
);


-- INSERT INTO terrain
-- (pointDroiteHautX, pointDroiteHautY, pointDroiteBasX, pointDroiteBasY, pointGaucheHautX, pointGaucheHautY, pointGaucheBasX, pointGaucheBasY, area)
-- VALUES
-- (10, 10, 10, 0, 0, 10, 0, 0, )

CREATE TABLE point
(
    id serial primary key,
    idTerrain int,
    x int,
    y int,
    vatoKg decimal,
    volamenaKg decimal,
    heureTotal int,
    pourcentage decimal,
    performanceParHeure decimal,
    foreign key (idTerrain) references terrain(id)  
);