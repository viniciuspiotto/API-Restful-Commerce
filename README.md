# Aplicação de API REST - Comércio

## Visão Geral
Bem-vindo ao projeto da Aplicação de Comércio! Este projeto foi implementado usando Java e Spring Boot, seguindo as melhores práticas de desenvolvimento de software. O design da aplicação é estruturado seguindo um diagrama UML detalhado, garantindo clareza e manutenibilidade do código.

## Funcionalidades
- Gerenciamento de produtos e categorias
- Processamento de pedidos e pagamentos
- Validação de dados e tratamento de exceções
- Endpoints RESTful para interação com a aplicação

## Design UML
![Diagrama UML](/img/commerce-uml.png)

O diagrama UML acima fornece uma visão geral de alto nível da arquitetura da aplicação, detalhando as classes e seus relacionamentos.

## Primeiros Passos
### Pré-requisitos
- Kit de Desenvolvimento Java (JDK) 11 ou superior
- Maven
- Git

### Instalação
1. Clone o repositório:
    ```bash
    git clone https://github.com/viniciuspiotto/API-Restful-Commerce.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd /API-Restful-Commerce
    ```

## Estrutura do Projeto

```bash
API-Restful-Commerce/
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── piotto
│   │   │           └── apiproduct
│   │   │               ├── ApiProductApplication.java
│   │   │               ├── domain
│   │   │               │   ├── Address.java
│   │   │               │   ├── BankSlipPayment.java
│   │   │               │   ├── Category.java
│   │   │               │   ├── City.java
│   │   │               │   ├── Client.java
│   │   │               │   ├── CreditCardPayment.java
│   │   │               │   ├── enums
│   │   │               │   │   ├── ClientType.java
│   │   │               │   │   └── PaymentState.java
│   │   │               │   ├── OrderItem.java
│   │   │               │   ├── OrderItemPK.java
│   │   │               │   ├── Order.java
│   │   │               │   ├── Payment.java
│   │   │               │   ├── Product.java
│   │   │               │   └── State.java
│   │   │               ├── repositories
│   │   │               │   ├── AddressRepository.java
│   │   │               │   ├── CategoryRepository.java
│   │   │               │   ├── CityRepository.java
│   │   │               │   ├── ClientRepository.java
│   │   │               │   ├── OrderItemRepository.java
│   │   │               │   ├── OrderRepository.java
│   │   │               │   ├── PaymentRepository.java
│   │   │               │   ├── ProductRepository.java
│   │   │               │   └── StateRepository.java
│   │   │               ├── resources
│   │   │               │   ├── CategoryResource.java
│   │   │               │   ├── ClientResource.java
│   │   │               │   ├── exceptions
│   │   │               │   │   ├── ResourceExceptionHandler.java
│   │   │               │   │   └── StandardError.java
│   │   │               │   └── OrderResource.java
│   │   │               └── services
│   │   │                   ├── CategoryService.java
│   │   │                   ├── ClientService.java
│   │   │                   ├── exceptions
│   │   │                   │   └── ObjectNotFoundException.java
│   │   │                   └── OrderService.java
│   │   └── resources
│   │       └── application.yml
```

## Endpoints da API

### Categorias
- `GET /categories/{id}`: Retorna a categoria e seus produtos

### Clientes
- `GET /clients/{id}`: Retorna o cliente, seus telefones e seus endereços

### Pedidos
- `GET /orders/{id}`: Retorna o pedido, seu cliente, seu pagamento e seus itens

## Contato
Para qualquer dúvida ou feedback, por favor, abra uma issue ou entre em contato comigo no [LinkedIn](https://br.linkedin.com/in/viniciushpiotto).