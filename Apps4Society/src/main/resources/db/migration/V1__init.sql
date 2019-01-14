CREATE TABLE usuarios (
	id SERIAL not null primary key ,
	actived boolean default true,
	email varchar(255),
	experacao_token boolean default false,
	login  varchar(255),
	nome varchar(255),
	password varchar(255)
	CONSTRAINT usuarios_pkey PRIMARY KEY (id));
