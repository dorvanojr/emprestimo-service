                                          
Este projeto é um sistema de gerenciamento de empréstimos desenvolvido para a Empresa X, uma instituição financeira inovadora que oferece soluções de crédito personalizadas para seus clientes. O sistema permite o cadastro de pessoas, a realização de empréstimos e o gerenciamento dessas operações de forma eficiente e segura.

Funcionalidades
Cadastro de Pessoas:

Operações CRUD para a entidade "Pessoa".

Definição automática do tipo de identificador (Pessoa Física, Pessoa Jurídica, Estudante Universitário, Aposentado) com base no tamanho do identificador.

Definição automática dos valores mínimos e máximos de empréstimo com base no tipo de identificador.

Realização de Empréstimos:

Criação de empréstimos vinculados a pessoas cadastradas.

Validação do identificador da pessoa antes de realizar o empréstimo.

Armazenamento de informações como valor do empréstimo, número de parcelas, status do pagamento e data de criação.

Gerenciamento de Dados:

Persistência de dados utilizando JPA e banco de dados H2 (para testes).

Relacionamento entre as entidades "Pessoa" e "Empréstimo".

Tecnologias Utilizadas
Spring Boot: Framework para desenvolvimento de aplicações Java.

Spring Data JPA: Para acesso e gerenciamento de dados.

H2 Database: Banco de dados em memória para desenvolvimento e testes.

Lombok: Para redução de código boilerplate.

JUnit e Mockito: Para testes unitários e de integração.

Maven: Para gerenciamento de dependências e build do projeto.

Configuração do Projeto
Pré-requisitos
Java 17

Maven 3.x

IDE de sua preferência (IntelliJ IDEA, Eclipse, etc.)
