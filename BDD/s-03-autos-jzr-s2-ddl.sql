--@Autor: Johan A. Zarazua Ramirez
--@Fecha creacion: 17/01/2023
--@Descripcion: Creacion de fragmentos nodo 4

--catalgos replicados
create table marca_r_jzr_s2 (
  marca_id      number(10,0)    not null,
  clave         varchar2(50)    not null,
  descripcion   varchar2(500)   not null,
  activo        number(1,0)     not null,
  constraint marca_r4_pk  primary key (marca_id)
);

create table modelo_r_jzr_s2 (
  modelo_id     number(10,0)    not null,
  clave         varchar2(50)    not null,
  descripcion   varchar2(500)   not null,
  activo        number(1,0)     not null,
  marca_id      number(10,0)    not null,
  constraint modelo_r4_pk primary key (modelo_id),
  constraint modelo_r4_marca_id_fk  foreign key (marca_id)
    references marca_r_jzr_s2 (marca_id)
);

create table status_auto(
  status_auto_id     number(2,0)   not null,
  clave         varchar2(20)  not null,
  descripcion   varchar2(40)  not null,
  constraint status_auto_pk primary key (status_auto_id)
);

create table auto_f1_jzr_s2 (
  auto_id   number(10,0)    not null,
  foto      blob            not null,
  constraint auto_f1_pk primary key (auto_id)
);

create table historico_status_f1_jzr_s2 (
  historico_status_id   number(10,0)  not null,
  fecha_status          date          not null,
  status_auto_id        number(2,0)   not null,
  auto_id               number(10,0)  not null,
  constraint historico_status_f1_pk primary key (historico_status_id),
  constraint historico_status_status_auto_id_fk foreign key (status_auto_id)
    references status_auto (status_auto_id),
  constraint historico_status_auto_id_fk foreign key (auto_id)
    references auto_f1_jzr_s2 (auto_id)
);

create table cliente_f3_jzr_s2 (
  cliente_id            number(10,0)    not null,
  nombre                varchar2(40)    not null,
  ap_paterno            varchar2(40)    not null,
  ap_materno            varchar2(40),
  num_identificacion    varchar2(18)    not null,
  email                 varchar2(500)   not null,
  constraint cliente_f3_pk primary key (cliete_id)
);

create table pago_auto_f3_jzr_s2 (
  cliente_id    number(10,0)    not null,
  auto_id       number(10,0)    not null,
  fecha_pago    date            not null,
  importe       number(8,2)     not null,
  recibo_pago   blob            not null,
  constraint pago_auto_f3_pk primary key (cliente_id, auto_id),
  constraint pago_auto_cliente_id_fk foreign key (cliente_id)
    references cliente_f3_jzr_s2 (status_auto_id)
);