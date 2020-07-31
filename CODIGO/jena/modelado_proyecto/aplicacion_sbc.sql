-- Generado por Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   en:        2020-07-28 12:12:32 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE dbpedia (
    id_dbpedia          INTEGER NOT NULL,
    sujeto              VARCHAR2(800 CHAR) NOT NULL,
    predicado           VARCHAR2(800 CHAR) NOT NULL,
    objeto              VARCHAR2(800 CHAR) NOT NULL,
    keyword_id_keyword  INTEGER NOT NULL
);

ALTER TABLE dbpedia ADD CONSTRAINT dbpedia_pk PRIMARY KEY ( id_dbpedia );

CREATE TABLE documentos (
    nombre  VARCHAR2(800 CHAR),
    fecha   DATE,
    tipo    VARCHAR2(80 CHAR),
    idioma  VARCHAR2(30),
    doi     VARCHAR2(800 CHAR) NOT NULL
);

ALTER TABLE documentos ADD CONSTRAINT documentos_pk PRIMARY KEY ( doi );

CREATE TABLE keyword (
    id_keyword      INTEGER NOT NULL,
    documentos_doi  VARCHAR2(800 CHAR) NOT NULL,
    keyword         VARCHAR2(100 CHAR) NOT NULL,
    lable           VARCHAR2(100 CHAR) NOT NULL,
    palabra         VARCHAR2(200 CHAR) NOT NULL,
    dbepedia        VARCHAR2(800 CHAR) NOT NULL
);

ALTER TABLE keyword ADD CONSTRAINT keyword_pk PRIMARY KEY ( id_keyword );

CREATE TABLE skos (
    id_skos             INTEGER NOT NULL,
    sujeto              VARCHAR2(800 CHAR) NOT NULL,
    predicado           VARCHAR2(800 CHAR) NOT NULL,
    objeto              VARCHAR2(800 CHAR) NOT NULL,
    dbpedia_id_dbpedia  INTEGER NOT NULL
);

ALTER TABLE skos ADD CONSTRAINT skos_pk PRIMARY KEY ( id_skos );

ALTER TABLE dbpedia
    ADD CONSTRAINT dbpedia_keyword_fk FOREIGN KEY ( keyword_id_keyword )
        REFERENCES keyword ( id_keyword );

ALTER TABLE keyword
    ADD CONSTRAINT keyword_documentos_fk FOREIGN KEY ( documentos_doi )
        REFERENCES documentos ( doi );

ALTER TABLE skos
    ADD CONSTRAINT skos_dbpedia_fk FOREIGN KEY ( dbpedia_id_dbpedia )
        REFERENCES dbpedia ( id_dbpedia );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
