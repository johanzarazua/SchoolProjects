--@Autor: Hernández Gómez Alejandro
--@Fecha creación: 18/01/2023
--@Descripción: Validación de sinonimos

Prompt validando sinonimos para pais
select
  (select count(*) from pais_f1) as pais_f1,
  (select count(*) from pais_f2) as pais_f1
from dual;

Prompt validando sinonimos para sucursal
select
  (select count(*) from sucursal_f1) as sucursal_f1,
  (select count(*) from sucursal_f2) as sucursal_f2,
  (select count(*) from sucursal_f3) as sucursal_f3
from dual;

Prompt validando sinonimos para auto
select
  (select count(*) from auto_f1) as auto_f1,
  (select count(*) from auto_f2) as auto_f2,
  (select count(*) from auto_f3) as auto_f3
from dual;

Prompt validando sinonimos para auto_particular
select
  (select count(*) from auto_particular_f1) as auto_particular_f1,
  (select count(*) from auto_particular_f2) as auto_particular_f2
from dual;

Prompt validando sinonimos para auto_carga
select
  (select count(*) from auto_carga_f1) as auto_carga_f1,
  (select count(*) from auto_carga_f2) as auto_carga_f2
from dual;

Prompt validando sinonimos para historico_status
select
  (select count(*) from historico_status_f1) as historico_status_f1,
  (select count(*) from historico_status_f2) as historico_status_f2
from dual;

Prompt validando sinonimos para cliente
select
  (select count(*) from cliente_f1) as cliente_f1,
  (select count(*) from cliente_f2) as cliente_f2,
  (select count(*) from cliente_f3) as cliente_f3
from dual;

Prompt validando sinonimos para pago_auto
select
  (select count(*) from pago_auto_f1) as pago_auto_f1,
  (select count(*) from pago_auto_f2) as pago_auto_f2,
  (select count(*) from pago_auto_f3) as pago_auto_f3
from dual;

Prompt validando sinonimos para tarjeta_cliente
select
  (select count(*) from tarjeta_cliente_f1) as tarjeta_cliente_f1,
  (select count(*) from tarjeta_cliente_f2) as tarjeta_cliente_f2
from dual;

Prompt validando sinonimos para marca
select
  (select count(*) from marca_r1) as marca_r1,
  (select count(*) from marca_r2) as marca_r2,
  (select count(*) from marca_r3) as marca_r3,
  (select count(*) from marca_r4) as marca_r4
from dual;

Prompt validando sinonimos para modelo
select
  (select count(*) from modelo_r1) as modelo_r1,
  (select count(*) from modelo_r2) as modelo_r2,
  (select count(*) from modelo_r3) as modelo_r3,
  (select count(*) from modelo_r4) as modelo_r4
from dual;