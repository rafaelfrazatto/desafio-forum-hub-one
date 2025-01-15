# Back-End Challenge: Fórum Hub - Alura & Oracle

## Sobre

Este desafio foi proposto como parte fundamental na trilha **"Java e Spring Framework G7 - ONE (Oracle Next Education)"**, mais especificamente do grupo de aulas com o tema **API REST com Java e Spring Boot**, destinada aos alunos da especialização em back-end do programa ONE, desenvolvido pela **Alura** em parceria com a **Oracle**. </br>
O projeto visa aplicar todos os conteúdos aprendidos durantes os cursos da trilha em questão e das anteriores, fazendo o uso principalmente do Spring Boot, criação de uma API Rest, JPA, autenticação e banco de dados (MySQL).</br>
O desafio era desenvolver uma API Rest para o Fórum Hub, um fórum onde um usuário pode fazer uma postagem de um novo tópico tirando suas dúvidas, listar todos os tópicos e também exibir, atualizar ou deletar um tópico já existente.</br>

## Tecnologias Utilizadas

- Java JDK: versão 21.
- Java Spring Boot Framework.
- Spring Security.
- Insomnia: Utilizado para testes da API.
- Java Persistence API (JPA).
- JSON Web Token (JWT).
- MySQL (Banco de Dados).
- IDE (preferencia pessoal): Foi utilizado o IntelliJ IDEA.

## Como executar o projeto

1. **Configurar o Ambiente:** Certifique-se de ter as configurações das variáveis de ambiente correspondentes como do projeto.

2. **Banco de Dados:** Certifique-se de possuir um banco de dados com o nome "forumhub_db".
   
3. **Obter o Projeto:** Faça o clone do projeto em sua máquina local.
   ```bash
   git clone https://github.com/rafaelfrazatto/desafio-forum-hub-one.git
   cd forum-hub
   ```
   
4. **Crie um Usuário:** Para a realização dos testes será necessário adicionar um usuário e senha manualmente o banco de dados.
    - Abra o MySQL pelo terminal de sua IDE utilizando seu login e senha:
      ```
      mysql -u root -p forumhub_db
      Enter password: root
      ```
    - Insira um usuário e senha no banco de dados. Para segurança, o BCrypt foi utilizado como algoritmo de hashing de senhas (a senha sem o algoritmo é 123456):
      ```
      insert into usuarios values (1, 'testes@email.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');
      ```
    - Verifique se está tudo certo e depois pode fechar o terminal.
      ```
      select * from usuarios;
      ```
      
5. **Executar a API Rest:** Execute a aplicação "ApiApplication.java" em sua IDE.
   
6. **Testes (Insomnia):** Use os endpoints para aplicação dos testes.

## Badge de Conclusão

