![java-logo](http://renanslopes8.com.br/projetosgit/readme-img/java_logo.png)

# java-jdbc-hsqldb #

Projeto Java usando JDBC com banco de dados HSQLDB, a API de JDBC (Application Programming Interface) é um conjunto de interfaces que dita e auxilia como devemos nos conectar com banco de dados através dos Drivers de aplicação. Este projeto usa o HSQLDB banco de dados em Java.

Encapsulamos o acesso ao banco de dados com DAO (Data Access Object), também foi encapsulado as conexões com o banco na classe ConnectionPool onde criamos um pool conexões e passamos as mesmas para nosso DAO se conectar com nosso banco, com esta implementação podemos mudar o nosso banco apenas alterando nossa classe de conexão a ConnectionPool.

Saiba como configurar o banco de dados HSQLDB em nosso projeto Java: 

#### Conceitos Aplicados no Projeto ####
 - Conceito de conexão com banco de dados com DriverManager
 - Conceito de abertura e fechamento das interfaces Connection, ResultSet e Statement segura usando o bloco try()
 - Protegendo o sistema de SQLInjection e usuários mal intencionados com o uso do prepareStatement
 - Aplicação do Pool de Conexões
 - Aplicação de Tabelas Relacionais
 - Acesso ao banco de dados para inserção e remoção de dados
 - Encapsulamento do acesso ao banco de dados através do DAO (Data Access Object) 

#### Recursos ####
 - Listar Produtos com as Categorias
 - Listar Produtos
 - Inserir novos produtos
 - Excluir produtos

####English####

Java project using JDBC with HSQLDB database, the JDBC API ( Application Programming Interface) is a set of interfaces that dictates and helps how we connect with the database through the application drivers . This project uses the HSQLDB Java database.

Encapsulate access to the database with DAO ( Data Access Object) was also encapsulated connections to the bank in ConnectionPool class where we created a pool connections and pass the same to our DAO to connect with our bank, with this implementation can change the our bank just changing our ConnectionPool the connection class .

Learn how to set up the HSQLDB database in our Java project :

#### Applied Concepts in Project ####
 - Connection concept with database with DriverManager
 - Opening and closing concept of interfaces Connection, ResultSet Statement and secure using the try block ()
 - Securing SQLInjection system and malicious users using the prepareStatement
 - Connection Pool Application
 - Relational Tables Application
 - Access to the database for insertion and removal of data
 - Encapsulation of access to the database through DAO (Data Access Object)

#### Resources ####
 - List Products with Categories
 - Products List
 - Insert new products
 - Delete products
