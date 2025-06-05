<h1 align="center" style="font-weight: bold;">Invent'IS Backend 💻</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Inicio</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#colab">Colaboradores</a> •
</p>

<p align="center">
    <b>Backend do sistema de almoxarifado + tombamento.</b>
</p>

<h2 id="technologies">💻 Tecnologias</h2>

- Java 21
- PostgreSQL
- Spring Boot (Spring Security, Spring JPA)

<h2 id="started">🚀 Inicio</h2>



<h3>Pre-requisitos</h3>

Para rodar o backend é preciso ter instalado o Java versão 21 na sua máquina e o PostgreSQL

- [Java 21](https://www.oracle.com/br/java/technologies/downloads/)
- [PostgeSQL](https://www.postgresql.org/download/)
- [Maven](https://maven.apache.org/download.cgi)

<h3>Clone o projeto</h3>

```bash
git clone https://github.com/Invent-IS/backend-almoxarifado
```

<h3>Rode o projeto</h3>

How to start your project

```bash
cd backend-almoxarifado
mvn install
mvn spring-boot:run
```

<h2 id="routes">📍 API Endpoints</h2>

<kbd>POST /auth/register</kbd>     | Cadastrar nova conta [response details](#get-auth-detail)

<kbd>POST /auth/login </kbd>     | Acessar conta [request details](#post-auth-detail)

<h3 id="get-auth-detail">POST /auth/register</h3>
**REQUEST**
```json
{
  "name": "Nome Exemplo",
  "email": "email@gmail.com",
  "password": "123",
  "roles": ["OPERATOR"]
}
```
**RESPONSE**
```json
{
  "name": "Nome Exemplo",
  "token": "OwoMRHsaQwyAgVoc3OXmL1JhMVUYXGGBbCTK0GBgiYitwQwjf0gVoBmkbuyy0pSi"
  "roles": ["OPERATOR"]
}
```


<h3 id="post-auth-detail">POST /auth/login</h3>

**REQUEST**
```json
{
  "email": "nome@gmail.com",
  "password": "123"
}
```

**RESPONSE**
```json
{
  "name": "Nome Exemplo",
  "token": "OwoMRHsaQwyAgVoc3OXmL1JhMVUYXGGBbCTK0GBgiYitwQwjf0gVoBmkbuyy0pSi"
  "roles": ["ADMIN", "OPERATOR"]
}
```

<h2 id="colab">🤝 Colaboradores</h2>


<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/88911920?v=4" width="100px;" alt="Luiz Guilherme"/><br>
        <sub>
          <b>Luiz Guilherme</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
