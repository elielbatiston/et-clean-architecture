<center>
  <h1 align="center">🚀 Encontro Técnico: Clean Architecture</h1>
  <p align="center">
    Exemplos de um sistema desenvolvido em MVC evoluindo para<br />
    Clean Architecture
  </p>
</center>
<br />

## Ferramentas necessárias

- JDK 17
- IDE de sua preferência
- Docker
- RabbitMQ
- Postgree

## Primeiros passos

**Passo 1:** Faça o clone do projeto no diretório de sua preferência.

```shell
git clone https://github.com/elielbatiston/et-clean-architecture
```

**Passo 2:** Vá para o terminal, acesse o diretório que você clonou o projeto e execute o comando abaixo:

```shell
docker-compose up -d
```

**Passo 3:** Dentro do diretório MVC ou Clean-Arch execute o comando abaixo:

```shell
mvn spring-boot:run
``` 

**Atenção**: A aplicação está programado para responder na porta 8080, 15432, 15672 e 5672. Caso estas portas na sua máquina estejam
ocupadas com outras aplicações, antes de subir os containers, favor editar o docker-compose.yml.<br/><br/>

**Observação**: Todas as informações abaixo levam em consideração que os containers estão com o status UP.

## Endereços da aplicação

1. __BackEnd:__ [http://localhost:8080](http://localhost:8080)
2. __RabbitMQ:__ [http://localhost:15672](http://localhost:15672) <br/>
__Usuario:__ rabbitmq <br/>
__Password:__ rabbitmq

## Como testar a aplicação

1. Teste da API: <br/>
__Arquivo do Postman:__ Arquivo do postman para importar e consumir a API.
[O arquivo pode ser baixado aqui](https://github.com/elielbatiston/et-clean-architecture/blob/main/et-clean-architecture.postman_collection)
   <br/><br/>
2. Teste da Fila no RabbitMQ: <br/>
__Endereço:__ http://localhost:15672 <br/>
__Fila:__ encontro.produtoevent <br/>
__Payload:__
```
{
  "n": "Rabbitmq",
  "p": 1.0
}
```