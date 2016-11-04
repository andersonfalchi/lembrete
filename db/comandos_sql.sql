CREATE TABLE produtos(
codigo integer not null,
descricao varchar(30) not null
)

insert into produtos(codigo, descricao)
values(1,'arroz')
;
insert into produtos(codigo, descricao)
values(2,'feijão')
;
insert into produtos(codigo, descricao)
values(3,'macarrão')
;
commit
;


select * from produtos


;

update produtos
set descricao = 'Arroz pré-cozido'
where codigo = 1
commit