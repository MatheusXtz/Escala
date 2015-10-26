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

create table funcionario (
  id_func                   bigint auto_increment not null,
  cpf                       varchar(255),
  nome                      varchar(255),
  email                     varchar(255),
  telefone                  varchar(255),
  setor_id_setor            bigint,
  constraint pk_funcionario primary key (id_func))
;

create table setor (
  id_setor                  bigint auto_increment not null,
  nome_setor                varchar(255),
  empresa_id_empre          bigint,
  constraint pk_setor primary key (id_setor))
;

create table usuario (
  idusuario                 bigint auto_increment not null,
  login                     varchar(255),
  senha                     varchar(255),
  funcionario_id_func       bigint,
  constraint pk_usuario primary key (idusuario))
;

alter table funcionario add constraint fk_funcionario_setor_1 foreign key (setor_id_setor) references setor (id_setor) on delete restrict on update restrict;
create index ix_funcionario_setor_1 on funcionario (setor_id_setor);
alter table setor add constraint fk_setor_empresa_2 foreign key (empresa_id_empre) references empresa (id_empre) on delete restrict on update restrict;
create index ix_setor_empresa_2 on setor (empresa_id_empre);
alter table usuario add constraint fk_usuario_funcionario_3 foreign key (funcionario_id_func) references funcionario (id_func) on delete restrict on update restrict;
create index ix_usuario_funcionario_3 on usuario (funcionario_id_func);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table empresa;

drop table funcionario;

drop table setor;

drop table usuario;

SET FOREIGN_KEY_CHECKS=1;

