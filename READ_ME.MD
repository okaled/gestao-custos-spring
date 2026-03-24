## Como utilizar a API

Como este projeto é um backend, as funcionalidades são acessadas via requisições HTTP (REST). Você pode testar usando ferramentas como Postman, Insomnia ou até mesmo pelo navegador para endpoints GET.

Base URL de produção:
```
https://gestao-custos-spring.onrender.com
```

### Exemplos de Endpoints

- **Listar todas as despesas (sem paginação):**
	- `GET /gestao/performance/sem-paginacao`
	- Exemplo: `https://gestao-custos-spring.onrender.com/gestao/performance/sem-paginacao`

- **Listar despesas com paginação:**
	- `GET /gestao/performance/com-paginacao?page=0&size=10`
	- Exemplo: `https://gestao-custos-spring.onrender.com/gestao/performance/com-paginacao?page=0&size=10`

- **Listar despesas por e-mail (com paginação):**
	- `GET /gestao/performance/com-paginacao/{email}?page=0&size=10`
	- Exemplo: `https://gestao-custos-spring.onrender.com/gestao/performance/com-paginacao/seu@email.com?page=0&size=10`

- **Listar despesas por e-mail com cache:**
	- `GET /gestao/performance/cache/{email}?page=0&size=10`
	- Exemplo: `https://gestao-custos-spring.onrender.com/gestao/performance/cache/seu@email.com?page=0&size=10`

Substitua `seu@email.com` pelo e-mail desejado.

---

# Gestão de Custos Pessoais

> Projeto Spring Boot para controle e gestão de despesas pessoais.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 4.0.4
- Maven
- H2 Database
- JPA
- Cache
- Docker

## Funcionalidades
- Cadastro, listagem e busca de despesas
- Endpoints com e sem paginação
- Cache para consultas por e-mail
- API RESTful

## Como rodar localmente
1. Certifique-se de ter o Java 21 e o Maven instalados.
2. Clone o repositório:
	```sh
	git clone https://github.com/okaled/gestao-custos-spring.git
	```
3. Acesse a pasta do projeto e execute:
	```sh
	mvn spring-boot:run
	```

## Deploy
O projeto já está disponível em produção no Render:

👉 [https://gestao-custos-spring.onrender.com](https://gestao-custos-spring.onrender.com)

---
Desenvolvido por Kauan Kaled
