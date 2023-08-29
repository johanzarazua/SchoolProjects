--@Autor: Hernández Gómez Alejandro
--@Fecha creación: 18/01/2023
--@Descripción: Creación de sinónimos

clear screen
whenever sqlerror exit rollback;
define autos_logon = 'connect autos_bdd/autos_bdd'

prompt =====================================
prompt Creando sinonimos para ahgbdd_s1
prompt =====================================
&autos_logon@ahgbdd_s1
@s-04-autos-ahg-s1-sinonimos.sql
@s-04-autos-valida-sinonimos.sql

prompt =====================================
prompt creando sinonimos para ahgbdd_s2
prompt =====================================
&autos_logon@ahgbdd_s2
@s-04-autos-ahg-s2-sinonimos.sql
@s-04-autos-valida-sinonimos.sql

prompt =====================================
prompt creando sinonimos para jzrbdd_s1
prompt =====================================
&autos_logon@jzrbdd_s1
@s-04-autos-jzr-s1-sinonimos.sql
@s-04-autos-valida-sinonimos.sql

prompt =====================================
prompt creando sinonimos para jzrbdd_s2
prompt =====================================
&autos_logon@jzrbdd_s2
@s-04-autos-jzr-s2-sinonimos.sql
@s-04-autos-valida-sinonimos.sql

prompt Listo!
disconnect