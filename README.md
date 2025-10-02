# service-notification

Serviço de notificação por e-mail do projeto [microservices-demo](https://github.com/Lucas-319/microservices-demo). Recebe solicitações do [service-task](https://github.com/Lucas-319/service-task) e envia e-mails via JavaMail para o Mailhog (SMTP).

## Tecnologias
- Java 21 
- Maven
- Spring Boot
- Spring Cloud: Netflix Eureka, Config Client
- Spring Mail (JavaMail)
- Docker

## Porta e Endpoint
- Porta: `8082`
- API interna:
  - `POST /notification` — recebe a solicitação de envio (chamado pelo `service-task`)

## Como se integra no projeto
- Descoberta e configuração:
  - Carrega propriedades do Config Server hospedado em [service-main](https://github.com/Lucas-319/service-main) (prefixo `/config`).
  - Registra-se no Eureka (também no `service-main`) para ser encontrado por consumidores.
- Fluxo com o [service-task](https://github.com/Lucas-319/service-task):
  1. O service-task identifica que deve notificar e realiza uma chamada HTTP via OpenFeign (FeignClient) para este serviço: `POST /notification` com `{"message":"...","email":"..."}`.
  2. A resolução do endereço ocorre via Eureka pelo nome lógico do serviço.
  3. Este serviço envia o e-mail via JavaMail para o Mailhog (SMTP `mailhog:1025`).
  4. A mensagem pode ser visualizada na UI do Mailhog: `http://localhost:8025`.

## Observação
- Endpoint destinado a uso interno entre serviços.
