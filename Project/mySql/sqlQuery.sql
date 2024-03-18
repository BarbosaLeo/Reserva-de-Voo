create database passagemAerea;
 
use passagemAerea;
create table atendente(
    id int primary key auto_increment,
    nome varchar(45),
    codigoUsuario int
);

insert into atendente(nome, codigoUsuario) values ("Marina", 123);

create table voo(
    id int primary key auto_increment,
    data date,
    origem varchar(45),
    destino varchar(45)
);

create table reserva(
    id int primary key auto_increment,
    dataReserva date,
    assento int,
    id_voo int,
    foreign key (id_voo) references voo(id)
);

create table passageiro(
    id int primary key auto_increment,
    nome varchar(45),
    cpf int,
    reserva_id int,
    foreign key (reserva_id) references reserva(id)
);


insert into voo(data, origem, destino) values
("2024-05-10", "Florianópolis-SC", "São Paulo-SP"),
("2024-03-20", "Florianópolis-SC", "São Paulo-SP"),
("2024-03-27", "Florianópolis-SC", "São Paulo-SP"),
("2024-04-01", "Florianópolis-SC", "São Paulo-SP"),
("2024-04-01", "Florianópolis-SC", "Salvador-BA"),
("2024-03-15", "Florianópolis-SC", "Salvador-BA"),
("2024-03-28", "Florianópolis-SC", "Salvador-BA"),
("2024-04-01", "Florianópolis-SC", "Porto Alegre-RS"),
("2024-03-17", "Florianópolis-SC", "Porto Alegre-RS");

insert into reserva(dataReserva,assento,id_voo) values("2024-05-10","3",1);
 
insert into passageiro(nome, cpf, reserva_id) values ("Nicolas", 11223344, 1);

-- select reserva.dataReserva, voo.destino, reserva.assento from voo 
	-- inner join reserva on reserva.id_voo = voo.id;

-- select reserva.dataReserva, voo.destino, reserva.assento, passageiro.nome from voo
-- inner join reserva on reserva.id_voo = voo.id
-- inner join passageiro on passageiro.reserva_id = reserva.id;

-- select * from reserva;
-- select * from passageiro;
-- select * from voo;
-- select * from reserva where dataReserva = "2024-05-10" and assento = 3 and id_voo = 1;
