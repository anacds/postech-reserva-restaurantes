Sistema de Reserva de Restaurantes | Pós-Tech FIAP
===============================================================

✨ Projeto desenvolvido como parte do Tech Challenge 3 da Pós-Tech FIAP.
Implementamos um sistema completo de gerenciamento de reservas de restaurantes.


-------------------------------------------------------------
🔧 Funcionalidades implementadas
-------------------------------------------------------------
📦 Endpoints disponíveis:

🪑 Mesa
POST /mesa → Criar uma nova mesa

GET /mesa/{id} → Buscar mesa por ID

GET /mesa/restaurante/{id} → Listar mesas de um restaurante

PUT /mesa/{id} → Atualizar dados da mesa

DELETE /mesa/{id} → Remover uma mesa

🗖 Reserva
POST /reserva → Criar nova reserva

GET /reserva/restaurante/{id} → Listar reservas de um restaurante

GET /reserva/usuario/{id} → Listar reservas de um usuário

GET /reserva/{id} → Buscar reserva por ID

DELETE /reserva/{id} → Cancelar uma reserva

PUT /reserva/{id} → Alterar dados de uma reserva

👥 Usuário
POST /usuarios → Criar novo usuário

GET /usuarios/{id} → Buscar usuário por ID

GET /usuarios/cpf/{cpf} → Buscar usuário por CPF

GET /usuarios → Listar todos os usuários

PUT /usuarios/{id} → Atualizar dados de um usuário

DELETE /usuarios/{id} → Deletar usuário

🍽️ Restaurantes
POST /restaurantes → Cadastrar novo restaurante

PUT /restaurantes/{id} → Atualizar restaurante

GET /restaurantes → Listar todos os restaurantes

GET /restaurantes/nome/{nome} → Buscar restaurante por nome

GET /restaurantes/{id} → Buscar restaurante por ID

GET /restaurantes/bairro/{bairro} → Buscar restaurante por bairro

GET /restaurantes/tipo-cozinha/{tipo} → Buscar restaurante por tipo de cozinha

DELETE /restaurantes/{id} → Deletar restaurante

⭐ Feedbacks
POST /feedbacks → Cadastrar feedback de um restaurante

GET /feedbacks/media-notas/{restauranteId} → Buscar média de notas de um restaurante

GET /feedbacks/comentarios/{restauranteId} → Buscar comentários de um restaurante

GET /feedbacks/{id} → Buscar feedback por ID



🧪 Testes
   - Testes unitários com JUnit & Mockito (TDD aplicado)
   - Testes de integração nos UseCases e Controller
   - Cobertura de testes com Jacoco (build report incluído)
   - Separacão por camadas (DTOs, Entities, Gateways, UseCases, Controller)

🚀 Deploys realizados
-------------------------------------------------------------

🔹 **AWS (ECS / Fargate + ECR Docker)**
   http://3.139.67.55:8080

🔹 **Heroku**
   https://postech-heroku2-920cb3859189.herokuapp.com

Ambos os ambientes estão funcionando com as mesmas rotas e estrutura RESTful.  
Todas as requisições podem ser feitas via Postman usando a collection compartilhada.

-------------------------------------------------------------
📂 Pasta Postman
-------------------------------------------------------------

A pasta `/postman` contém os arquivos para facilitar os testes:

📁 postman/
├── postech-collection.json         → Collection com todos os endpoints
├── env-localhost.json              → Ambiente local
├── env-heroku.json                 → Ambiente Heroku
└── env-aws.json                    → Ambiente AWS

⚙️ Basta importar no Postman para iniciar os testes de forma dinâmica com `{{base_url}}`.

-------------------------------------------------------------
📌 Observações
-------------------------------------------------------------

- A aplicação está estruturada em **camadas limpas**, com injeção de dependência e boas práticas.
- Segue princípios SOLID, separação de responsabilidades e arquitetura hexagonal.
- DTOs protegem a entrada e saída de dados na API.
- Regras de negócio encapsuladas nos UseCases.
- Repositório de usuários utilizando MongoDB com Spring Data.

💡 Projeto buildado com Java 17 + Spring Boot 3.4.3.

-------------------------------------------------------------
Feito com 💙

