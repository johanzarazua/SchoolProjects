--@Autor: Johan A. Zarazua Ramirez
--@Fecha creacion: 18/01/2023
--@Descripcion: Creacion de los frgamentos en todos los nodos

clear screen
whenever sqlerror exit rollback;
set serveroutput on
define autos_logon = 'connect autos_bdd/autos_bdd'

prompt ==================================================================
prompt Creando fragmentos en ahgbdd_s1
prompt ==================================================================
connect &autos_logon@ahgbdd_s1
@s-03-autos-ahg-s1-ddl.sql

prompt ==================================================================
prompt Creando fragmentos en ahgbdd_s2
prompt ==================================================================
connect &autos_logon@ahgbdd_s2
@s-03-autos-ahg-s2-ddl.sql

prompt ==================================================================
prompt Creando fragmentos en jzrbdd_s1
prompt ==================================================================
connect &autos_logon@jzrbdd_s1
@s-03-autos-jzr-s1-ddl.sql

prompt ==================================================================
prompt Creando fragmentos en jzrbdd_s2
prompt ==================================================================
connect &autos_logon@jzrbdd_s2
@s-03-autos-jzr-s2-ddl.sql

prompt Listo!!!
disconnect