-- Generado por Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   en:        2020-07-27 21:48:05 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE dbpedia (
    keyword_dbepedia  VARCHAR2(800 CHAR) NOT NULL,
    predicado         VARCHAR2(800 CHAR),
    objeto            VARCHAR2(800 CHAR) NOT NULL
);

ALTER TABLE dbpedia ADD CONSTRAINT dbpedia_pk PRIMARY KEY ( objeto );

CREATE TABLE documentos (
    nombre  VARCHAR2(800 CHAR),
    fecha   DATE,
    tipo    VARCHAR2(80 CHAR),
    idioma  VARCHAR2(30),
    doi     VARCHAR2(800 CHAR) NOT NULL
);

ALTER TABLE documentos ADD CONSTRAINT documentos_pk PRIMARY KEY ( doi );

CREATE TABLE keyword (
    documentos_doi  VARCHAR2(800 CHAR) NOT NULL,
    keyword         VARCHAR2(100 CHAR),
    lable           VARCHAR2(100 CHAR),
    palabra         VARCHAR2(200 CHAR),
    dbepedia        VARCHAR2(800 CHAR) NOT NULL
);

ALTER TABLE keyword ADD CONSTRAINT keyword_pk PRIMARY KEY ( dbepedia );

CREATE TABLE skos (
    dbpedia_objeto  VARCHAR2(800 CHAR) NOT NULL,
    predicado       VARCHAR2(800 CHAR),
    objeto          VARCHAR2(800 CHAR)
);

ALTER TABLE dbpedia
    ADD CONSTRAINT dbpedia_keyword_fk FOREIGN KEY ( keyword_dbepedia )
        REFERENCES keyword ( dbepedia );

ALTER TABLE keyword
    ADD CONSTRAINT keyword_documentos_fk FOREIGN KEY ( documentos_doi )
        REFERENCES documentos ( doi );

ALTER TABLE skos
    ADD CONSTRAINT skos_dbpedia_fk FOREIGN KEY ( dbpedia_objeto )
        REFERENCES dbpedia ( objeto );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              6
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
