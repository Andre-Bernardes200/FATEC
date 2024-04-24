# Exercicio 1
use Biblioteca;
select e.edi_descricao from Editora as e
where e.edi_cod = 1;

# Exercicio 2
use Biblioteca;
select count(t.tel_ddd) as contagem_ddd from Telefone as t
inner join Pessoa as p on
p.pes_cod = t.pes_cod
where t.tel_ddd = 12;

# Exercicio 3
use Biblioteca;
select p.pes_nome, e.emp_cod From Pessoa as p
inner join Emprestimo as e on
e.pes_cod = p.pes_cod
where e.emp_cod = 1;

# Exercicio 4
use Biblioteca;
select p.pes_nome, a.pes_nro_matricula, t.tel_numero from Pessoa as p
left join Aluno as a on
a.pes_cod = p.pes_cod
left join Telefone as t on
p.pes_cod = t.pes_cod
where a.pes_nro_matricula is not null;

# Exercicio 5

drop database if exists Politica ;

create database Politica;
use Politica;

create table Partido(
idPartido int primary key,
siglaPartido int,
descricaoPartido varchar(30));

create table Deputado(
idDeputado int primary key,
idPartido int,
nomeDeputado varchar(30));

create table Sessao(
idSessao int primary key,
dataSessao date,
horaSessao varchar(4),
decisao varchar(4));

create table Participacao(
idSessao int ,
idDeputado int,
primary key(idSessao,idDeputado));

alter table Deputado
add constraint fk_Deputado_Partido foreign key(idPartido) references Partido(idPartido);

alter table Participacao
add constraint fk_Participacao_Sessao foreign key(idSessao) references Sessao(idSessao);

alter table Participacao
add constraint fk_Participacao_Deputado foreign key(idDeputado) references Deputado(idDeputado);

# Exercicio 6
use Politica;
alter table Partido 
drop column siglaPartido;

alter table Partido 
add column siglaPartido int unique;

# Exercicio 7

use Politica;
select d.idDeputado, p.siglaPartido from Partido as p
inner join Deputado as d on
p.idPartido = d.idPartido;