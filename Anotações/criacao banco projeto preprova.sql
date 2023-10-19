create database banco2;
use banco2;
create table produto (
	id int primary key not null,
	nome  varchar (50) not null,
	marca varchar (50),
	preco double
);

SELECT * FROM PRODUTO;