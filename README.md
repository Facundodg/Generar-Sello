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

CONSULTAS PARA POSTMAN:

CONSULTA HOLA ADMIN:
GET
http://localhost:5050/admin 
Bearer Token

CONSULTA HOLA ADMIN:
POST
http://localhost:5050/publico/authenticate 
{
  
  "usuario":"munidigital",
  "clave":"secreto"

}
CONSULTA PARA GENERAR TOKEN SIN LOGUEO:
POST
http://localhost:5050/publico/authenticate/sinToken

CONSULTA PARA GENERAR SELLO:
POST
http://localhost:5050/sello
Bearer Token






# Configuración para SQL Server
#spring.datasource.sqlserver.url=jdbc:sqlserver://172.20.255.15:1433;databaseName=Express
#spring.datasource.sqlserver.username=root
#spring.datasource.sqlserver.password=root
#Espring.datasource.sqlserver.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver


#produccion
#spring.datasource.url=jdbc:postgresql://${BASE_DATOS_URL:172.20.255.15}:9005/ms_habilitacion

#localhost
#spring.datasource.url=jdbc:postgresql://localhost:9005/ms_habilitacion

#dimsmt.gob.ar
#spring.datasource.url=jdbc:postgresql://dimsmt.gob.ar:5050/ms_habilitacion

#servidor 15
#spring.datasource.url=jdbc:postgresql://172.20.255.15:9005/ms_habilitacion

#spring.datasource.username=root

# Configuración para SQL Server
#spring.datasource.sqlserver.url=jdbc:sqlserver://172.20.254.236:1433;databaseName=PROGRAM
#spring.datasource.sqlserver.username=prueba
#spring.datasource.sqlserver.password=prueba
#spring.datasource.sqlserver.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

