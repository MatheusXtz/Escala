# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table empresa (
  id_empre                  bigint auto_increment not null,
  cnpj                      varchar(255),
  inscricaoestadual         varchar(255),
  razao                     varchar(255),
  email                     varchar(255),
  telefone                  varchar(255),
  logradouro                varchar(255),
  cidade                    varchar(255),
  estado                    varchar(255),
  cep                       varchar(255),
  constraint pk_empresa primary key (id_empre))
;

create table folga (
  id_folga                  bigint auto_increment not null,
  dia                       varchar(255),
  constraint pk_folga primary key (id_folga))
;

create table funcionario (
  id_func                   bigint auto_increment not null,
  cpf                       varchar(255),
  nome                      varchar(255),
  email                     varchar(255),
  telefone                  varchar(255),
  setor_id_setor            bigint,
  constraint pk_funcionario primary key (id_func))
;

create table horario (
  id_horario                bigint auto_increment not null,
  hora_inicial              varchar(255),
  hora_final                varchar(255),
  constraint pk_horario primary key (id_horario))
;

create table intervalo (
  id_intervalo              bigint auto_increment not null,
  hora_inicial              varchar(255),
  hora_final                varchar(255),
  constraint pk_intervalo primary key (id_intervalo))
;

create table setor (
  id_setor                  bigint auto_increment not null,
  nome_setor                varchar(255),
  empresa_id_empre          bigint,
  constraint pk_setor primary key (id_setor))
;

create table tipo_escala (
  id_tipo_escala            bigint auto_increment not null,
  horario_id_horario        bigint,
  intervalo_id_intervalo    bigint,
  constraint pk_tipo_escala primary key (id_tipo_escala))
;

create table turno (
  id_turno                  bigint auto_increment not null,
  descricao                 varchar(255),
  horario_id_horario        bigint,
  intervalo_id_intervalo    bigint,
  constraint pk_turno primary key (id_turno))
;

create table usuario (
  idusuario                 bigint auto_increment not null,
  login                     varchar(255),
  senha                     varchar(255),
  constraint pk_usuario primary key (idusuario))
;

alter table funcionario add constraint fk_funcionario_setor_1 foreign key (setor_id_setor) references setor (id_setor) on delete restrict on update restrict;
create index ix_funcionario_setor_1 on funcionario (setor_id_setor);
alter table setor add constraint fk_setor_empresa_2 foreign key (empresa_id_empre) references empresa (id_empre) on delete restrict on update restrict;
create index ix_setor_empresa_2 on setor (empresa_id_empre);
alter table tipo_escala add constraint fk_tipo_escala_horario_3 foreign key (horario_id_horario) references horario (id_horario) on delete restrict on update restrict;
create index ix_tipo_escala_horario_3 on tipo_escala (horario_id_horario);
alter table tipo_escala add constraint fk_tipo_escala_intervalo_4 foreign key (intervalo_id_intervalo) references intervalo (id_intervalo) on delete restrict on update restrict;
create index ix_tipo_escala_intervalo_4 on tipo_escala (intervalo_id_intervalo);
alter table turno add constraint fk_turno_horario_5 foreign key (horario_id_horario) references horario (id_horario) on delete restrict on update restrict;
create index ix_turno_horario_5 on turno (horario_id_horario);
alter table turno add constraint fk_turno_intervalo_6 foreign key (intervalo_id_intervalo) references intervalo (id_intervalo) on delete restrict on update restrict;
create index ix_turno_intervalo_6 on turno (intervalo_id_intervalo);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table empresa;

drop table folga;

drop table funcionario;

drop table horario;

drop table intervalo;

drop table setor;

drop table tipo_escala;

drop table turno;

drop table usuario;

SET FOREIGN_KEY_CHECKS=1;

