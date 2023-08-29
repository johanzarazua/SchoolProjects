--@Autor: Johan A. Zarazua Ramirez
--@Fecha creacion: 17/01/2023
--@Descripcion: Creacion de ligas en los 4 nodos

clear screen
whenever sqlerror exit rollback;
set serveroutput on
define autos_logon = 'connect autos_bdd/autos_bdd'

prompt ==================================================================
prompt Creando ligas en ahgbdd_s1
prompt ==================================================================
&autos_logon@ahgbdd_s1
--PDB local
create database link ahgbdd_s2.fi.unam using 'AHGBDD_S2';
--PDB remota
create database link jzrbdd_s1.fi.unam using 'JZRBDD_S1';
create database link jzrbdd_s2.fi.unam using 'JZRBDD_S2';

prompt ==================================================================
prompt Creando ligas en ahgbdd_s2
prompt ==================================================================
&autos_logon@ahgbdd_s2
--PDB local
create database link ahgbdd_s1.fi.unam using 'AHGBDD_S1';
--PDB remota
create database link jzrbdd_s1.fi.unam using 'JZRBDD_S1';
create database link jzrbdd_s2.fi.unam using 'JZRBDD_S2';

prompt ==================================================================
prompt Creando ligas en jzrbdd_s1
prompt ==================================================================
&autos_logon@jzrbdd_s1
--PDB local
create database link jzrbdd_s2.fi.unam using 'JZRBDD_S2';
--PDB remota
create database link ahgbdd_s1.fi.unam using 'AHGBDD_S1';
create database link ahgbdd_s2.fi.unam using 'AHGBDD_S2';

prompt ==================================================================
prompt Creando ligas en jzrbdd_s2
prompt ==================================================================
&autos_logon@jzrbdd_s2
--PDB local
create database link jzrbdd_s1.fi.unam using 'JZRBDD_S1';
--PDB remota
create database link ahgbdd_s1.fi.unam using 'AHGBDD_S1';
create database link ahgbdd_s2.fi.unam using 'AHGBDD_S2';

prompt Listo!!!
disconnect