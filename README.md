> Sergio Luan: [Github](https://github.com/sergioyi) e [Linkedin](www.linkedin.com/in/sergio-dos-santos-7b2142261)
## Lista de Requisitos:
✅1) Deverá ser desenvolvido um microserviço ("Microserviço 1") como cliente em que receberá requisições HTTP em um endpoint chamado "POST /pagar"

✅2) Deverá ser desenvolvido um microserviço ("Microserviço 2") como servidor em que receberá requisições HTTP do microserviço 1 no endpoint "POST /notificar" 

✅3) Este microserviço 2 deverá postar uma mensagem em um tópico de mensageria (Ex. AWS SQS ou Rabbit MQ) 

✅4) Ambos os serviços deverão ter um Dockerfile ou docker-compose e um arquivo README explicando como subir os serviços 

#   explicando como subir os serviços
Instalando uma imagem RabbitMQ do dockerhub:
```shell
docker pull rabbitmq:management
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management

```
\
Buscando o host do container para configurações dos microserviços 1 e 2, custuma ter 11 números:
```shell
sudo hostname -I
```
⚠️⚠️ O valor retornado deve-se usar no host nas configurações dos microserviços: [microserviço1](./microservico1/src/main/resources/application.properties#L3) e [microserviço2](./microservico2/src/main/resources/application.properties); e para comunicação entre os microserviços, deve ser colocado na url do microserviço2 a [substituição](./microservico1/src/main/java/com/workspace/microservico1/controller/Pagamento.java#L13) de http://localhost:8081/notificar http://<ID_DO_HSOTNAME>:8081/notificar

### Microserviço1 
```shell
cd microservico1
sudo docker build -t microservico1-docker .
sudo docker run -d -p 8080:8080 microservico1-docker
```
### Microserviço2 
```shell
cd microservico2
sudo docker build -t microservico2-docker .
sudo docker run -d -p 8081:8081 microservico2-docker
```
## Usando a API
http://localhost:8080/swagger-ui/swagger-ui/index.html

Ele espera um valor double.
## Acessando o RabbitMQ
Para acessar o ambiente do RabbitMq:  http://localhost:15672/ onde vai pedir usuário e senha \
Senha: `guest`\
Usuário: `guest`\
Na tela inicial do Rabbitmq, vá até o ponto de `Exchanges`, e clique em `amq.topic`, dentro de Bindings, clique na palavra `topicopagamento` e por ultimo Get mensages
