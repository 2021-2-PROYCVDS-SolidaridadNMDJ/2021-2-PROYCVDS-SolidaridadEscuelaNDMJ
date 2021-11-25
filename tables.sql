CREATE TABLE if not exists tblogin(
    idcorreo VARCHAR PRIMARY KEY,
    contraseña VARCHAR NOT NULL,
    nombre VARCHAR NOT NULL,
    apellido VARCHAR NOT NULL,
    rol VARCHAR NOT NULL
);