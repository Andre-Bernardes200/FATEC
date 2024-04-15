create database bdpratica1;

#drop database bdpratica1;

use bdpratica1;

create table funcionario(

cod_func int(4) primary key auto_increment,
nome varchar(100) not null,
cpf varchar(15) unique,
salario float(6,2),
endereco varchar(252),
sexo char(1) check (sexo  in ("M","F")),
cod_super int(4),
cod_depart int(4)
);

create table dependente(
seq int(4) primary key auto_increment,
nome varchar(100) not null,
parentesco varchar(30) not null check (parentesco in ("PAI", "MÃE", "IRMAOS","FILHO")),
data_nasc date,
cod_func int(4)
);

create table departamento(
cod_depart int(4) primary key auto_increment,
nome varchar(30) not null,
data_inicial date
);

create table localizacao(
local varchar(252) primary key,
cod_depart int(4)
);

create table participa(
cod_func int(4),
cod_proj int(4),
horas varchar(50)
);

create table projeto(
cod_proj int(4) primary key auto_increment,
cod_depart int(4),
titulo varchar(150) not null,
descricao varchar(252),
data_cad datetime default (now())
);

alter table funcionario
add constraint fk_auto_relacionamento_cod_func foreign key (cod_super) references funcionario(cod_func);

alter table funcionario
add constraint fk_func_depart foreign key (cod_depart) references departamento(cod_depart);

alter table dependente
add constraint fk_dependente_funcionario foreign key (cod_func) references funcionario(cod_func);

alter table participa
add constraint fk_func_participa foreign key (cod_func) references funcionario(cod_func);

alter table participa
add constraint fk_projeto_participa foreign key (cod_proj) references projeto(cod_proj);

alter table localizacao
add constraint fk_depart_local foreign key (cod_depart) references departamento(cod_depart);

alter table projeto
add constraint fk_depart_proj foreign key (cod_depart) references departamento (cod_depart);