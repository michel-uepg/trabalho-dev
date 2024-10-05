# Trabalho de Desenvolvimento de API para Gerenciamento de Pagamentos de Mensalistas

## Sobre o Projeto
Este projeto é uma API desenvolvida em Java, usando o framework Spring, para gerenciar pagamentos de mensalistas em jogos de futebol. Ele foi desenvolvido como parte do curso de Engenharia de Software da UEPG, 2º ano.

## Integrantes da Equipe
- Michel de Lima
- Rafael Elger
- André Pereira Justiniano

## Tecnologias Utilizadas
- Java 22.0.2
- Spring Boot 3.3.3
- PostgreSQL

## Estrutura do Banco de Dados
### Tabelas Criadas
**Tabela `jogador`**:
```sql
CREATE TABLE jogador (
    cod_jogador SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    data_nasc DATE NOT NULL
);
CREATE TABLE pagamento (
    cod_pagamento SERIAL PRIMARY KEY,
    ano SMALLINT NOT NULL,
    mes SMALLINT NOT NULL,
    valor NUMERIC(10, 2) NOT NULL,
    cod_jogador INTEGER NOT NULL,
    CONSTRAINT fk_jogador FOREIGN KEY (cod_jogador) REFERENCES jogador (cod_jogador)
);
