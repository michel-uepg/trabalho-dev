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

## Endpoints da API
Jogador
GET /api/jogadores - Listar todos os jogadores.
POST /api/jogadores - Criar um novo jogador.
GET /api/jogadores/{id} - Buscar um jogador pelo ID.
PUT /api/jogadores/{id} - Atualizar um jogador pelo ID.
DELETE /api/jogadores/{id} - Deletar um jogador pelo ID.
Pagamento
GET /api/pagamentos - Listar todos os pagamentos.
POST /api/pagamentos - Criar um novo pagamento.
GET /api/pagamentos/{id} - Buscar um pagamento pelo ID.
DELETE /api/pagamentos/{id} - Deletar um pagamento pelo ID.

## Estrutura do Banco de Dados
### Tabelas Criadas
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
