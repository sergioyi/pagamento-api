> Sergio Luan: [Github](https://github.com/sergioyi) e [Linkedin](www.linkedin.com/in/sergio-dos-santos-7b2142261)
## Lista de Requisitos:
✅1) Deverá ser desenvolvido um microserviço ("Microserviço 1") como cliente em que receberá requisições HTTP em um endpoint chamado "POST /pagar"

🚨2) Deverá ser desenvolvido um microserviço ("Microserviço 2") como servidor em que receberá requisições HTTP do microserviço 1 no endpoint "POST /notificar" 

🚨3) Este microserviço 2 deverá postar uma mensagem em um tópico de mensageria (Ex. AWS SQS ou Rabbit MQ) 

🚨4) Ambos os serviços deverão ter um Dockerfile ou docker-compose e um arquivo README explicando como subir os serviços 

#   explicando como subir os serviços
Instalando uma imagem RabbitMQ do dockerhub:
```shell
sudo docker pull rabbitmq:4.0.2
```
Criando e executando um container:
```shell
sudo docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0.2
```
Buscando o host do container:
```shell
sudo hostname -I
```
O valor retornado deve-se usar no host nas [configurações da aplicação](/src/main/resources/application.properties)