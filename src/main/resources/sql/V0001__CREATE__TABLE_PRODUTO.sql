CREATE TABLE sch_mercado.produto (
	id bigserial NOT NULL,
	nome varchar NOT NULL,
	preco numeric(10,2) not null,
	quantidade_estoque bigint NOT NULL,
	codigo_de_barras varchar NOT NULL
);