package com.workspace.microservico1.conexao;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQ implements CommandLineRunner{
    
    private final String tipoDeEnvio = "amq.direct";
    private final String nomeDeFila = "filapagamento";
    
    private AmqpAdmin rabbitAdmin;    //  configuração do rabbitmq do enviador
    public RabbitMQ(AmqpAdmin rabbitAdmin) {
        this.rabbitAdmin = rabbitAdmin;
    }

    //  ferramentas de envio de mensagem
    private Queue fila (){
        return new Queue(nomeDeFila);
    }
    private DirectExchange trocaDireta (){
        return new DirectExchange(tipoDeEnvio);
    }
    private Binding relacionamento (){
        return new Binding(nomeDeFila, DestinationType.QUEUE, tipoDeEnvio, nomeDeFila, null);
    }
    
    //  enviador
    public void contrucao(){
        Queue fila = this.fila();
        DirectExchange trocaDireta = this.trocaDireta();
        Binding relacionamento = this.relacionamento();
        
        this.rabbitAdmin.declareQueue(fila);
        this.rabbitAdmin.declareExchange(trocaDireta);
        this.rabbitAdmin.declareBinding(relacionamento);
    }
    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        this.contrucao();
    }
}
