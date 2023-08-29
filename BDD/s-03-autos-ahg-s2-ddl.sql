--@Autor: Hernández Gómez Alejandro
--@Fecha creación: 17/01/2023
--@Descripción: Creación de fragmentos nodo 2

--whenever sqlerror exit rollback

-- 
-- table: pais_f2_ahg_s1
--
create table pais_f2_ahg_s2(
  pais_id          number(4, 0) not null,
  nombre           varchar2(40) not null,
  clave            varchar(4)   not null,
  region           varchar2(3)  not null,
  constraint pais_f2_pk primary key (pais_id)
);

-- 
-- table: sucursal_f3_ahg_s2
--
create table sucursal_f3_ahg_s2(
  sucursal_id         number(10, 0)   not null,
  nombre              varchar2(40)    not null,
  clave               varchar2(8)     not null,
  sucursal_anexa_id   number(10,0)    null,
  pais_id             number(4,0)     not null,
  constraint sucursal_f3_pk primary key (sucursal_id)
);

-- 
-- table: auto_f3_ahg_s2
--
create table auto_f3_ahg_s2(
  auto_id             number(10, 0)   not null,
  anio                number(4, 0)    not null,
  num_serie           varchar2(20)    not null,
  tipo                char(1)         not null,
  precio              number(9, 2)    not null,
  fecha_status        date            not null,
  sucursal_id         number(10, 0)   not null,
  status_auto_id      number(2, 0)    not null,
  modelo_id           number(10, 0)   not null,
  constraint auto_f3_pk primary key (auto_id),
  constraint auto_f3_sucursal_id_fk foreign key (sucursal_id)
  references sucursal_f3_ahg_s2(sucursal_id)
);

-- 
-- table: auto_particular_f2_ahg_s2
--
create table auto_particular_f2_ahg_s2(
  auto_id             number(10, 0)   not null,
  num_cilindros       number(1, 0)    not null,
  num_pasajeros       number(1, 0)    not null,
  clase               char(1)         not null,
  constraint auto_particular_f2_pk primary key (auto_id),
  constraint auto_particular_f2_auto_id_fk foreign key (auto_id)
  references auto_f3_ahg_s2(auto_id)
);

-- 
-- table: auto_carga_f2_ahg_s2
--
create table auto_carga_f2_ahg_s2(
  auto_id             number(10, 0)   not null,
  peso_maximo         number(10, 2)   not null,
  volumen             number(10, 2)   not null,
  tipo_combustible    char(1)         not null,
  constraint auto_carga_f2_pk primary key (auto_id),
  constraint auto_carga_f2_auto_id_fk foreign key (auto_id)
  references auto_f3_ahg_s2(auto_id)
);

-- 
-- table: cliente_f1_ahg_s2
--
create table cliente_f1_ahg_s2(
  cliente_id          number(10, 0)   not null,
  nombre              varchar2(40)    not null,
  ap_paterno          varchar2(40)    not null,
  ap_materno          varchar2(40)    null,
  num_identificacion  varchar2(18)    not null,
  email               varchar2(500)   not null,
  constraint cliente_f1_pk primary key (cliente_id)
);

-- 
-- table: pago_auto_f1_ahg_s2
--
create table pago_auto_f1_ahg_s2(
  cliente_id          number(10, 0)   not null,
  auto_id             number(10, 0)   not null,
  ap_paterno          varchar2(40)    not null,
  fecha_pago          date            not null,
  importe             number(8, 2)    not null,
  recibo_pago         blob            not null,
  constraint pago_auto_f1_pk primary key (cliente_id, auto_id),
  constraint pago_auto_f1_cliente_id_fk foreign key (cliente_id)
  references cliente_f1_ahg_s2(cliente_id)
);

-- 
-- table: tarjeta_cliente_f2_ahg_s2
--
create table tarjeta_cliente_f2_ahg_s2(
  cliente_id          number(10, 0)   not null,
  anio_expira         varchar2(2)     not null,
  mes_expira          varchar2(2)     not null,
  constraint tarjeta_cliente_f2_pk primary key (cliente_id),
);

-- 
-- table: status_auto
--
create table status_auto(
  status_auto_id      number(2, 0)   not null,
  clave               varchar2(20)   not null,
  descripcion         varchar2(40)   not null,
  constraint status_auto_pk primary key (auto_id)
);

-- 
-- table: marca_r_ahg_s2
--
create table marca_r_ahg_s2(
  marca_id            number(3, 0)    not null,
  clave               varchar2(50)    not null,
  descripcion         varchar2(500)   not null,
  activo              number(1, 0)    not null,
  constraint marca_ahg_s2_pk primary key (marca_id)
);

-- 
-- table: modelo_r_ahg_s1
--
create table modelo_r_ahg_s2(
  modelo_id           number(10, 0)   not null,
  clave               varchar2(50)    not null,
  descripcion         varchar2(500)   not null,
  activo              number(1, 0)    not null,
  marca_id            number(3, 0)    not null,
  constraint modelo_ahg_s2_pk primary key (modelo_id),
  constraint modelo_ahg_s2_marca_id_fk foreign key (marca_id)
  references marca_r_ahg_s2(marca_id)
);