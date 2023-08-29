--@Autor: Johan A. Zarazua Ramirez
--@Fecha creacion: 17/01/2023
--@Descripcion: Creacion de usuarios en cada nodo

clear screen
whenever sqlerror exit rollback;
set serveroutput on

prompt Iniciando la creacion/eliminacion de usuarios.
accept syspass char prompt 'Proporcione el password de sys: ' hide

prompt ==================================================================
prompt Creando usuario en ahgbdd_s1
prompt ==================================================================
connect sys/&&syspass@ahgbdd_s1 as sysdba
@s-01-autos-usuario.sql

prompt ==================================================================
prompt Creando usuario en ahgbdd_s2
prompt ==================================================================
connect sys/&&syspass@ahgbdd_s2 as sysdba
@s-01-autos-usuario.sql

prompt ==================================================================
prompt Creando usuario en jzrbdd_s1
prompt ==================================================================
connect sys/&&syspass@jzrbdd_s1 as sysdba
@s-01-autos-usuario.sql

prompt ==================================================================
prompt Creando usuario en jzrbdd_s2
prompt ==================================================================
connect sys/&&syspass@jzrbdd_s2 as sysdba
@s-01-autos-usuario.sql

prompt Listo!!!
disconnect