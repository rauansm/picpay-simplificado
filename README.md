# 🗳 Desafio PicPay Backend Sênior

## 📑 Sobre o Projeto
Projeto elaborado para solucionar esse desafio https://github.com/PicPay/picpay-desafio-backend para uma vaga backend com perfil sênior. A solução desenvolvida é basicamente uma versão simplificada do PicPay.

## Architecture Haiku
### Objetivos do Negócio
- Simplificar as transações financeiras entre usuários e lojistas.
- Garantir a confiança e segurança em todas as transações realizadas.
- Oferecer uma plataforma que permita transferências de dinheiro entre usuários e lojistas de forma rápida e precisa.

### Restrições
- Operação na nuvem.
- Persistência de dados.
- Foco no back-end.

### Atributos de Qualidade
Segurança > Disponibilidade > Escalabilidade

### Decisões de Design
- Java Spring Boot, Maven, Docker Compose, RabbitMQ, Postgres.
- API RESTful.
- Integração com sistema externo para autorizar transferencia.
- Mensageria para envio de notificação.
- Estratégia para situação de concorrência.

### Arquitetura
![Picpay simplificado drawio](https://github.com/rauansm/picpay-simplificado/assets/143328092/71ccf538-9fbd-44c8-9fc2-09bcd7e03589)

## 📂 Pré-Requisitos
- Java 17
- Maven
- Docker e Docker Compose
  
## 💻  Como Executar o Projeto
1. Clone o repositório: git clone https://github.com/rauansm/picpay-simplificado
2. Executar a aplicação Spring Boot
3. Inicie os serviços usando Docker Compose: docker-compose up
4. O sistema estará rodando e acessível.

## Testando a Aplicação
- Importe a collection do Postman fornecida para testar as APIs.
  
[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://god.gw.postman.com/run-collection/30868128-64657a28-b731-4bc2-8edd-f15f5d776abe?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D30868128-64657a28-b731-4bc2-8edd-f15f5d776abe%26entityType%3Dcollection%26workspaceId%3D1b17a6e1-66db-4752-ba99-f6fbc4ac45ff)
