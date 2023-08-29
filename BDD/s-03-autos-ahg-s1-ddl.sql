--@Autor: Hernández Gómez Alejandro
--@Fecha creación: 17/01/2023
--@Descripción: Creación de fragmentos nodo 1

--whenever sqlerror exit rollback

-- 
-- table: pais_f1_ahg_s1
--
create table pais_f1_ahg_s1(
  pais_id          number(4, 0) not null,
  nombre           varchar2(40) not null,
  clave            varchar(4)   not null,
  region           varchar2(3)  not null,
  constraint pais_f1_pk primary key (pais_id)
);

-- 
-- table: sucursal_f2_ahg_s1
--
create table sucursal_f2_ahg_s1(
  sucursal_id         number(10, 0)   not null,
  nombre              varchar2(40)    not null,
  clave               varchar2(8)     not null,
  sucursal_anexa_id   number(10,0)    null,
  pais_id             number(4,0)     not null,
  constraint sucursal_f2_pk primary key (sucursal_id)
);

-- 
-- table: auto_f2_ahg_s1
--
create table auto_f2_ahg_s1(
  auto_id             number(10, 0)   not null,
  anio                number(4, 0)    not null,
  num_serie           varchar2(20)    not null,
  tipo                char(1)         not null,
  precio              number(9, 2)    not null,
  fecha_status        date            not null,
  sucursal_id         number(10, 0)   not null,
  status_auto_id      number(2, 0)    not null,
  modelo_id           number(10, 0)   not null,
  constraint auto_f2_pk primary key (auto_id),
  constraint auto_f2_sucursal_id_fk foreign key (sucursal_id)
  references sucursal_f2_ahg_s1(sucursal_id)
);

-- 
-- table: auto_particular_f1_ahg_s1
--
create table auto_particular_f1_ahg_s1(
  auto_id             number(10, 0)   not null,
  num_cilindros       number(1, 0)    not null,
  num_pasajeros       number(1, 0)    not null,
  clase               char(1)         not null,
  constraint auto_particular_f1_pk primary key (auto_id),
  constraint auto_particular_f1_auto_id_fk foreign key (auto_id)
  references auto_f2_ahg_s1(auto_id)
);

-- 
-- table: auto_carga_f1_ahg_s1
--
create table auto_carga_f1_ahg_s1(
  auto_id             number(10, 0)   not null,
  peso_maximo         number(10, 2)   not null,
  volumen             number(10, 2)   not null,
  tipo_combustible    char(1)         not null,
  constraint auto_carga_f1_pk primary key (auto_id),
  constraint auto_carga_f1_auto_id_fk foreign key (auto_id)
  references auto_f2_ahg_s1(auto_id)
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
-- table: marca_r_ahg_s1
--
create table marca_r_ahg_s1(
  marca_id            number(3, 0)   not null,
  clave               varchar2(50)    not null,
  descripcion         varchar2(500)   not null,
  activo              number(1, 0)    not null,
  constraint marca_ahg_s1_pk primary key (marca_id)
);

-- 
-- table: modelo_r_ahg_s1
--
create table modelo_r_ahg_s1(
  modelo_id           number(10, 0)   not null,
  clave               varchar2(50)    not null,
  descripcion         varchar2(500)   not null,
  activo              number(1, 0)    not null,
  marca_id            number(3, 0)    not null,
  constraint modelo_ahg_s1_pk primary key (modelo_id),
  constraint modelo_ahg_s1_marca_id_fk foreign key (marca_id)
  references marca_r_ahg_s1(marca_id)
);