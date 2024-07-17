create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    fechaCreacion datetime not null,
    respuestas varchar(100) not null,

    primary key(id)

);
