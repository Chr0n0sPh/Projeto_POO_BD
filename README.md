# Projeto Conjunto Entre as Disciplinas C207 e C206

#### Ideia Desenvolvida
Este projeto foi desenvolvido como parte final das disciplina de Banco de Dados I e Programação Orientada a Objetos com JAVA. Como tema foi desenvolvido um SGBD para a abertura de Ordens de Serviços para um setor de Engenharia Clínica.

#### BANCO DE DADOS
Como Banco de Dados foi utilizado o MySQL para modelagem do banco de dados e criação das tabelas. Foram atribuidos relacionamentos 1:1; 1:N e N:M da seguinte forma:

#### Relacionamento 1:N
Foi definito no escopo do projeto que seriam realizados os cadastros dos Equipamentos e Setores de um Hospital cada um com seus atributos relevantes e foi definido que um equipamento pertence a um setor e um setor pode possuir vários equipamentos, componto assim o relacionamento 1:N

#### Relacionamento N:M
Foi definito no escopo do projeto que seria realizado cadastro de Ordens de Serviços e Técnicos, cada um com seus atributos relevantes e foi definido que uma ordem de serviço pode ser atendida por N Técnicos e um técnico pode ser responsável por M Ordens de Serviço, componto assim o relacionamento N:M

#### Relacionamento 1:1
Foi definito no escopo do projeto que para alguns setores que são considerados críticos que um Técnico ficaria Responsável pelo Setor e somente ele poderia atuar nos chamados feitos por aquele setor, componto assim o relacionamento 1:1.

#### POO
O Backend do projeto foi desenvolvido utilizando-se a Linguagem Orientada a Objetos JAVA, que está executando a coleta dos dados via Terminal do ambiente de desenvolvimento IntelliJ e a comunicação com o Banco de Dados MySQL para realizar os CRUDs.
