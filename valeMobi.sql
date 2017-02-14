drop database valeMobi;
create database valeMobi;
use  valeMobi;

create table mercadoria(
idMercadoria int primary key auto_increment,
nome varchar(40) not null,
preco float(10) not null,
quantidade int not null,
tipoMercadoria varchar(40) not null,
tipoNegociacao varchar(40) not null
);

create table venda(
idVenda int primary key auto_increment,
quantidade int(10) not null,
idMercadoria int, 
FOREIGN KEY (idMercadoria)
  REFERENCES mercadoria (idMercadoria)
);

create table compra(
idCompra int primary key auto_increment,
quantidade int(10) not null,
idMercadoria int, 
FOREIGN KEY (idMercadoria)
  REFERENCES mercadoria (idMercadoria)
);
