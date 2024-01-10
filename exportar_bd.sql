-- Adminer 4.8.1 PostgreSQL 15.2 (Debian 15.2-1.pgdg110+1) dump

DROP TABLE IF EXISTS "categoria";
DROP SEQUENCE IF EXISTS categoria_id_seq;
CREATE SEQUENCE categoria_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."categoria" (
    "id" bigint DEFAULT nextval('categoria_id_seq') NOT NULL,
    "tico_categoria" character varying(255),
    CONSTRAINT "categoria_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "categoria" ("id", "tico_categoria") VALUES
(1,	'CATEGORIA A');

DROP TABLE IF EXISTS "costo_urbano";
DROP SEQUENCE IF EXISTS costo_urbano_id_seq;
CREATE SEQUENCE costo_urbano_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."costo_urbano" (
    "id" bigint DEFAULT nextval('costo_urbano_id_seq') NOT NULL,
    "costo" double precision NOT NULL,
    CONSTRAINT "costo_urbano_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "costo_urbano" ("id", "costo") VALUES
(1,	17);

DROP TABLE IF EXISTS "datos";
CREATE TABLE "public"."datos" (
    "id_datos" bigint NOT NULL,
    "mts_cuadrados" double precision NOT NULL,
    "padron" character varying(255),
    "sub_tipo_tasa" character varying(255),
    "tasa" character varying(255),
    CONSTRAINT "datos_pkey" PRIMARY KEY ("id_datos")
) WITH (oids = false);


DROP TABLE IF EXISTS "hab_concepto_tarif";
DROP SEQUENCE IF EXISTS hab_concepto_tarif_id_seq;
CREATE SEQUENCE hab_concepto_tarif_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."hab_concepto_tarif" (
    "id" bigint DEFAULT nextval('hab_concepto_tarif_id_seq') NOT NULL,
    "cant_urbanos" bigint,
    "fecha" timestamp,
    "id_costo_urbano" bigint,
    "id_categoria" bigint,
    CONSTRAINT "hab_concepto_tarif_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "hab_concepto_tarif" ("id", "cant_urbanos", "fecha", "id_costo_urbano", "id_categoria") VALUES
(1,	285,	'2024-01-09 12:00:00',	1,	1);

DROP TABLE IF EXISTS "hab_tramite_concepto";
DROP SEQUENCE IF EXISTS hab_tramite_concepto_id_seq;
CREATE SEQUENCE hab_tramite_concepto_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

DROP SEQUENCE IF EXISTS hab_tramite_concepto_id_concepto_tarif_seq;
CREATE SEQUENCE hab_tramite_concepto_id_concepto_tarif_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."hab_tramite_concepto" (
    "id" bigint DEFAULT nextval('hab_tramite_concepto_id_seq') NOT NULL,
    "id_concepto_tarif" bigint DEFAULT nextval('hab_tramite_concepto_id_concepto_tarif_seq') NOT NULL,
    "id_tramite_tarif" bigint NOT NULL,
    CONSTRAINT "hab_tramite_concepto_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


DROP TABLE IF EXISTS "hab_tramite_tarif";
DROP SEQUENCE IF EXISTS hab_tramite_tarif_tipo_seq;
CREATE SEQUENCE hab_tramite_tarif_tipo_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."hab_tramite_tarif" (
    "id" bigint NOT NULL,
    "tipo" bigint DEFAULT nextval('hab_tramite_tarif_tipo_seq') NOT NULL,
    "descripcion" character varying(255),
    "desc_corta" character varying(255),
    "fecha" timestamp,
    CONSTRAINT "hab_tramite_tarif_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "hab_tramite_tarif" ("id", "tipo", "descripcion", "desc_corta", "fecha") VALUES
(1,	1,	'Habilitacion Negocio',	'Habilitacion Negocio',	'2024-01-09 12:00:00');

DROP TABLE IF EXISTS "sello";
CREATE TABLE "public"."sello" (
    "id_sello" bigint NOT NULL,
    "id_s" bigint,
    "importe" double precision NOT NULL,
    CONSTRAINT "sello_pkey" PRIMARY KEY ("id_sello")
) WITH (oids = false);


ALTER TABLE ONLY "public"."hab_concepto_tarif" ADD CONSTRAINT "hab_concepto_tarif_id_categoria_fkey" FOREIGN KEY (id_categoria) REFERENCES categoria(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."hab_concepto_tarif" ADD CONSTRAINT "hab_concepto_tarif_id_costo_urbano_fkey" FOREIGN KEY (id_costo_urbano) REFERENCES costo_urbano(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."hab_tramite_concepto" ADD CONSTRAINT "fkab6u320eqkrbb6jjnwi72a0vn" FOREIGN KEY (id_concepto_tarif) REFERENCES hab_concepto_tarif(id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."hab_tramite_concepto" ADD CONSTRAINT "fkcd4qaic21wsbecr4xeeov0pnd" FOREIGN KEY (id_tramite_tarif) REFERENCES hab_tramite_tarif(id) NOT DEFERRABLE;

-- 2024-01-10 03:53:26.300318+00
