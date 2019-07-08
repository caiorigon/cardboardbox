BEGIN;

DROP TABLE IF EXISTS transportadora1;

CREATE TABLE transportadora1
(
  tipotransporte integer NOT NULL, -- tipo
  tempo integer, -- tempo por km em segundos
  valor double precision, -- valor por km
  CONSTRAINT transportadora_pkey PRIMARY KEY (tipotransporte)
);

INSERT INTO transportadora1(tipotransporte, tempo, valor)
VALUES
   (2, 60, 50.00);

COMMIT;