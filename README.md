
# SmartBrSite

> Status: Finalizado ✅

### Um programa que simula o site da SmartBR

É uma versão inspirada no site da empresa SmartBR que realiza o cadastro de visitantes que desejam deixar uma mensagem. Para a realização desse projeto 
foi feito o CRUD (Create, Read, Update, Delete) para persistir os dados no banco PostgreSQL. 
O padrão de projeto utilizado é o MVC (Model, View, Controller). O model possui a classe DAO que acessa o banco de dados e a classe Contato, que
é responsável pelo mapeamento da tabela contato no banco de dados. A classe controller realiza a intermediação entre o view e o model, solicitando dados
da classe DAO e redirecionando entre as páginas do site. A view são as páginas que o usuário tem acesso e interage. 

A linguagem Java utilizando o framework Hibernate faz a intermediação entre banco de dados e a visão do usuário, administrando as requisições feitas para 
realizar uma ação na base de dados.

Assim, com por meio do CRUD desenvolvido é possível criar e armazenar os usuários no banco de dados. É possível visualizar os dados dos 
visitantes cadastrados, editar as informações deles e remover um usuário do banco de dados.

## Features

- [X] Cria o cadastro do visitante
- [X] Exibe uma lista dos visitantes com suas informações
- [X] Atualiza o cadastro, podendo mudar as informações do visitante, inclusive a mensagem
- [X] Deleta o cadastro do banco de dados

## Technologias Usadas:

- [Java](https://www.oracle.com/java/technologies/downloads/)
- [HTML5](https://dev.w3.org/html5/html-author/)
- [CSS](https://www.w3.org/Style/CSS/Overview.en.html)
- [Javascript](https://www.javascript.com)
- [PostgreSQL](https://www.postgresql.org)
- [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html)
- [Apache Tomcat](https://tomcat.apache.org)
- [NetBeans](https://netbeans.apache.org/download/index.html)
- [Hibernate](https://hibernate.org)

## Site onde as imagens foram retiradas

[IconFinder](https://www.iconfinder.com)
