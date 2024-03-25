create table usuario (
id uuid not null,
nome varchar(255) not null,
email varchar (150) not null,
cpf_cnpj varchar(14) not null,
senha varchar(30) not null,
tipo_usuario varchar(20) not null,
carteira decimal(20,2) not null,
data_cadastro timestamp not null,

primary key (id));

alter table usuario
add constraint unique_email unique (email);

alter table usuario
add constraint unique_cpf_cnpj unique (cpf_cnpj);




