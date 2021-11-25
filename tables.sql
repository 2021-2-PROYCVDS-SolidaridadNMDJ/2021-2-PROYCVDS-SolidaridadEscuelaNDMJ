CREATE TABLE if not exists tblogin(
    idcorreo VARCHAR PRIMARY KEY,
    contraseña VARCHAR NOT NULL,
    nombre VARCHAR NOT NULL,
    apellido VARCHAR NOT NULL,
    rol VARCHAR NOT NULL
);

 insert into tblogin(idCorreo,contraseña,nombre,apellido,rol) values ('julian.pena-m@mail.escuelaing.edu.co','1234','Julian','Peña','Estudiante');