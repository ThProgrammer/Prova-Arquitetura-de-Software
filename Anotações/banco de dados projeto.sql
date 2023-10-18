create schema banco;
use banco;
create table produto(
codigo int not null primary key,
nome varchar(50) not null,
marca varchar(50) null,
preco double
);

insert into produto values(1, "Tv", "Samsung", 3000.00);
select * from produto;
insert into produto values(2, "Console", "Xbox", 2400.00);
delete from produto where codigo=1;
delete from produto where nome="console";