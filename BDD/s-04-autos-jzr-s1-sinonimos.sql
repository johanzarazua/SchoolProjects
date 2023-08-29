--@Autor: Hernández Gómez Alejandro
--@Fecha creación: 18/01/2023
--@Descripción: Creación de sinónimos en jzrbdd_s1

--pais
create or replace synonym pais_f1 for pais_f1_ahg_s1@ahgbdd_s1;
create or replace synonym pais_f2 for pais_f2_ahg_s2@ahgbdd_s2;

--sucursal
create or replace synonym sucursal_f1 for sucursal_f1_jzr_s1;
create or replace synonym sucursal_f2 for sucursal_f2_ahg_s1@ahgbdd_s1;
create or replace synonym sucursal_f3 for sucursal_f3_ahg_s2@ahgbdd_s2;

--auto
create or replace synonym auto_f1 for auto_f1_jzr_s2@jzrbdd_s2;
create or replace synonym auto_f2 for auto_f2_ahg_s1@ahgbdd_s1;
create or replace synonym auto_f3 for auto_f3_ahg_s2@ahgbdd_s2;

--auto_particular
create or replace synonym auto_particular_f1 for auto_particular_f1_ahg_s1@ahgbdd_s1;
create or replace synonym auto_particular_f2 for auto_particular_f2_ahg_s2@ahgbdd_s2;

--auto_carga
create or replace synonym auto_carga_f1 for auto_carga_f1_ahg_s1@ahgbdd_s1;
create or replace synonym auto_carga_f2 for auto_carga_f2_ahg_s2@ahgbdd_s2;

--historico_status
create or replace synonym historico_status_f1 for historico_status_f1_jzr_s2@jzrbdd_s2;
create or replace synonym historico_status_f2 for historico_status_f2_jzr_s1;

--cliente
create or replace synonym cliente_f1 for cliente_f1_ahg_s2@ahgbdd_s2;
create or replace synonym cliente_f2 for cliente_f2_jzr_s1;
create or replace synonym cliente_f3 for cliente_f3_jzr_s2@jzrbdd_s2;

--pago_auto
create or replace synonym pago_auto_f1 for pago_auto_f1_ahg_s2@ahgbdd_s2;
create or replace synonym pago_auto_f2 for pago_auto_f2_jzr_s1;
create or replace synonym pago_auto_f3 for pago_auto_f3_jzr_s2@jzrbdd_s2;

--tarjeta_cliente
create or replace synonym tarjeta_cliente_f1 for tarjeta_cliente_f1_jzr_s1;
create or replace synonym tarjeta_cliente_f2 for tarjeta_cliente_f2_ahg_s2@ahgbdd_s2;

--marca
create or replace synonym marca_r1 for marca_r_ahg_s1@ahgbdd_s1;
create or replace synonym marca_r2 for marca_r_ahg_s2@ahgbdd_s2;
create or replace synonym marca_r3 for marca_r_jzr_s1;
create or replace synonym marca_r4 for marca_r_jzr_s2@jzrbdd_s2;

--modelo
create or replace synonym modelo_r1 for modelo_r_ahg_s1@ahgbdd_s1;
create or replace synonym modelo_r2 for modelo_r_ahg_s2@ahgbdd_s2;
create or replace synonym modelo_r3 for modelo_r_jzr_s1;
create or replace synonym modelo_r4 for modelo_r_jzr_s2@jzrbdd_s2;