TABLAS DE LA BASE DE DATOS:



CREATE TABLE hab_tramite_tarif(

    id bigint NOT NULL,
    tipo bigserial NOT NULL,
    descripcion character varying(255),
    fecha timestamp without time zone

);

CREATE TABLE hab_tramite_concepto(

    id bigserial NOT NULL,
    id_tramite bigserial NOT NULL,
    id_concepto bigint NOT NULL

);

CREATE TABLE hab_concepto_tarif(

    id bigserial NOT NULL,
    id_concepto bigserial NOT NULL,
    id_categoria bigint,
    cant_urbanos bigint,
    fecha timestamp without time zone

);

drop table hab_tramite_tarif;
drop table hab_concepto_tarif;

CREATE TABLE hab_concepto_tarif(
    id serial PRIMARY KEY,
    id_concepto bigint NOT NULL,
    id_categoria bigint,
    cant_urbanos bigint,
    fecha timestamp without time zone
);

CREATE TABLE hab_tramite_tarif(
    id serial PRIMARY KEY,
    tipo bigint NOT NULL,
    descripcion character varying(255),
    fecha timestamp without time zone
);
