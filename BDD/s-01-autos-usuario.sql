--@Autor: Johan A. Zarazua Ramirez
--@Fecha creacion: 17/01/2023
--@Descripcion: Eliminacion y creacion de usuario

define usuario_autos = 'autos_bdd'
set serveroutput on

--validando existencia de usuario
declare
  v_count number;
begin
  select count(*) into v_count from dba_users where lower(usuario_autos) =  &usuario_autos;
  if v_count > 0 then
    execute immediate 'drop user &usuario_autos cascade';
  else
    dbms_output.put_line('El usuario &usuario_autos no existe');
  end if;
end;
/

--creacion de usuario
grant
  create session,
  create table,
  create procedure,
  create sequence,
  create database link,
  create synonym, 
  create view, 
  create type
to &usuario_autos identified by &usuario_autos;
alter user &usuario_autos quota unlimited on users;
