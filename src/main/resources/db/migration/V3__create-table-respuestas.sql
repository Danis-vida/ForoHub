create table respuestas(

    id bigint not null auto_increment,
    mensaje varchar(100) not null,
    fechaCreacion datetime not null,
    solucion varchar(100) not null,

    primary key(id)

);
