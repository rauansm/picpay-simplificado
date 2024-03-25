create table transferencia (
id uuid not null,
valor decimal(20,2) not null,
pagador uuid not null,
beneficiario uuid not null,
data_criacao timestamp not null,
version bigint not null,

primary key (id),
constraint fk_pagador foreign key  (pagador) references usuario (id),
constraint fk_beneficiario foreign key  (beneficiario) references usuario (id));





