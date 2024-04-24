insert into Pessoa (pes_cod,pes_nome,cpf,rg,email) values(1,'Ana',11111111111,2894587,'ana@gmail.com');
insert into Pessoa (pes_cod,pes_nome,cpf,rg,email) values(2,'Raul',22222222222,3894587,'raul@gmail.com');
insert into Pessoa (pes_cod,pes_nome,cpf,rg,email) values(3,'Laura',33333333333,4894587,'laura@gmail.com');
insert into Pessoa (pes_cod,pes_nome,cpf,rg,email) values(4,'Juliana',44444444444,5894587,'pasquini.juliana@gmail.com');
insert into Pessoa (pes_cod,pes_nome,cpf,rg,email) values(5,'Adriana',55555555555,6894587,'adriana@gmail.com');

insert into Professor (pes_cod,titulacao) values (4,'mestrado');
insert into Professor (pes_cod,titulacao) values (5,'doutorado');


insert into Aluno (pes_cod,pes_nro_matricula) values (1,34567890);
insert into Aluno (pes_cod,pes_nro_matricula) values (2,34567891);
insert into Aluno (pes_cod,pes_nro_matricula) values (3,34567892);


insert into Telefone (tel_cod,tel_numero,tip_descricao,tel_ddd,pes_cod) values (1,39234444,'RESIDENCIAL',12,1);
insert into Telefone (tel_cod,tel_numero,tip_descricao,tel_ddd,pes_cod) values (2,39244446,'PROFISSIONAL',12,2);
insert into Telefone (tel_cod,tel_numero,tip_descricao,tel_ddd,pes_cod) values (3,39244447,'PROFISSIONAL',12,4);
insert into Telefone (tel_cod,tel_numero,tip_descricao,tel_ddd,pes_cod) values (4,39244447,'PROFISSIONAL',12,5);

insert into Editora (edi_cod,edi_descricao) values (1,'Campus');
insert into Editora (edi_cod,edi_descricao) values (2,'Pearson');


insert into Livro values (1,'Sistema de BD',3,'2008',2);
insert into Livro  values (2,'Banco de Dados',1,'2006',1);
insert into Livro  values (3,'LP',1,'2006',1);
insert into Livro  values (4,'Projeto de BD',1,'2009',2);
insert into Livro  values (5,'Eng.Software',2,'2008',1);
insert into Livro values (6,'Marketing',2,'2008',1);
insert into Livro  values (7,'Projeto de Redes',2,'2008',1);


insert into Exemplar values (5,1,1,null);
insert into Exemplar values (6,2,1,null);
insert into Exemplar values(7,3,1,null);
insert into Exemplar values(8,4,1,null);

insert into Exemplar values(1,1,2,null);
insert into Exemplar values(2,2,2,null);
insert into Exemplar values(3,3,2,null);
insert into Exemplar values(4,4,2,null);


insert into Exemplar values(9,1,3,null);
insert into Exemplar values(10,2,3,null);
insert into Exemplar values(11,3,3,null);
insert into Exemplar values(12,4,3,null);

insert into Exemplar values(13,1,4,null);
insert into Exemplar values(14,2,4,null);
insert into Exemplar values(15,3,4,null);
insert into Exemplar values(16,4,4,null);

insert into Exemplar values(17,1,5,null);
insert into Exemplar values(18,2,5,null);
insert into Exemplar values(19,3,5,null);
insert into Exemplar values(20,4,5,null);

insert into Emprestimo values
(1,1,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(2,1,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(3,2,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(4,2,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(5,3,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(6,3,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(7,4,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(8,4,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(9,5,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(10,5,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(11,5,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(12,5,date_format('2015-11-03','%Y-%m-%d'),date_format('2015-11-18','%Y-%m-%d')),
(13,5,date_format('2015-10-10','%Y-%m-%d'),date_format('2015-10-25','%Y-%m-%d'));

insert into ITEM_EMPRESTIMO values(1,1);
insert into ITEM_EMPRESTIMO values(1,2);
insert into ITEM_EMPRESTIMO values(2,4);
insert into ITEM_EMPRESTIMO values(3,1);
insert into ITEM_EMPRESTIMO values(4,2);
insert into ITEM_EMPRESTIMO values(5,2);
insert into ITEM_EMPRESTIMO values(6,1);
insert into ITEM_EMPRESTIMO values(7,2);
insert into ITEM_EMPRESTIMO values(8,2);
insert into ITEM_EMPRESTIMO values(9,2);
insert into ITEM_EMPRESTIMO values(10,3);
insert into ITEM_EMPRESTIMO values(11,6);
insert into ITEM_EMPRESTIMO values(12,6);
insert into ITEM_EMPRESTIMO values(13,7);
insert into ITEM_EMPRESTIMO values(7,4);



insert into Devolucao values
(1,date_format(now(),'%Y-%m-%d'),1,1),
(2,date_format(now(),'%Y-%m-%d'),3,1),
(3,date_format(now(),'%Y-%m-%d'),10,3),
(4,date_format(now(),'%Y-%m-%d'),9,5),
(5,date_format(now(),'%Y-%m-%d'),7,4);


