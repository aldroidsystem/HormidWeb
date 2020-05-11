CREATE OR REPLACE PACKAGE pg_globalVariable AS
   EXECUTED_SUCCESSFULLY INTEGER;
   EXECUTED_FAILED INTEGER;
END pg_globalVariable;
/
CREATE OR REPLACE PACKAGE BODY pg_globalVariable AS
BEGIN
   EXECUTED_SUCCESSFULLY := 00;
   EXECUTED_FAILED := 99;
END pg_globalVariable;
/