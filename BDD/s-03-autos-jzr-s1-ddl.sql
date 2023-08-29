--@Autor: Johan A. Zarazua Ramirez
--@Fecha creacion: 17/01/2023
--@Descripcion: Creacion de fragmentos nodo 3

--catalgos replicados
create table marca_r_jzr_s1 (
  marca_id      number(10,0)    not null,
  clave         varchar2(50)    not null,
  descripcion   varchar2(500)   not null,
  activo        number(1,0)     not null,
  constraint marca_r3_pk  primary key (marca_id)
);

create table modelo_r_jzr_s1 (
  modelo_id     number(10,0)    not null,
  clave         varchar2(50)    not null,
  descripcion   varchar2(500)   not null,
  activo        number(1,0)     not null,
  marca_id      number(10,0)    not null,
  constraint modelo_r3_pk primary key (modelo_id),
  constraint modelo_r3_marca_id_fk  foreign key (marca_id)
    references marca_r_jzr_s1 (marca_id)
);

create table status_auto (
  status_auto_id     number(2,0)   not null,
  clave              varchar2(20)  not null,
  descripcion        varchar2(40)  not null,
  constraint status_auto_pk primary key (status_auto_id)
);

create table sucursal_f1_jzr_s1 (
  sucursal_id         number(10,2)    not null,
  nombre              varchar2(40)    not null,
  clave               varchar2(8)     not null,
  sucursal_anexa_id   number(10,0)    not null,
  pais_id             number(4,0)     not null,
  constraint sucursal_f1_pk primary key (sucursal_id)
);

create table historico_status_f2_jzr_s1 (
  historico_status_id   number(10,0)  not null,
  fecha_status          date          not null,
  status_auto_id        number(2,0)   not null,
  auto_id               number(10,0)  not null,
  constraint historico_status_f2_pk primary key (historico_status_id),
  constraint historico_status_status_auto_id_fk foreign key (auto_id)
    references status_auto (status_auto_id)
);

create table cliente_f2_jzr_s1 (
  cliente_id            number(10,0)    not null,
  nombre                varchar2(40)    not null,
  ap_paterno            varchar2(40)    not null,
  ap_materno            varchar2(40),
  num_identificacion    varchar2(18)    not null,
  email                 varchar2(500)   not null,
  constraint cliente_f2_pk primary key (cliete_id)
);

create table pago_auto_f2_jzr_s1 (
  cliente_id    number(10,0)    not null,
  auto_id       number(10,0)    not null,
  fecha_pago    date            not null,
  importe       number(8,2)     not null,
  recibo_pago   blob            not null,
  constraint pago_auto_f2_pk primary key (cliente_id, auto_id),
  constraint pago_auto_cliente_id_fk foreign key (cliente_id)
    references cliente_f2_jzr_s1 (status_auto_id)
);

create table tarjeta_cliente_f1_jzr_s1 (
  cliente_id        number(10,0)    not null,
  num_tarjeta       varchar2(16)    not null,
  codigo_seguridad  number(3,0)  not null,
  constraint tarjeta_cliente_f1_pk primary key (cliente_id)
);