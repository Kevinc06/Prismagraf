CREATE DATABASE IF NOT EXISTS bancoprismagraf;

USE bancoprismagraf;

CREATE TABLE produto(


 codprod int not null,
 nomeprod varchar (60)  not null,
 quantidade  int not null,
 valordevenda varchar (50) not null,
 
 constraint pk_produto primary key (codprod)
 

);

CREATE TABLE cliente(

codcli int not null,
nomecli varchar (50) not null,
email varchar(60) not null,
idade int not null,
telefone varchar (15) not null,
codprod int not null,

 constraint pk_cliente PRIMARY KEY (codcli),
 constraint fk_cliente FOREIGN KEY (codprod) references produto (codprod)
 
 );
 
 


