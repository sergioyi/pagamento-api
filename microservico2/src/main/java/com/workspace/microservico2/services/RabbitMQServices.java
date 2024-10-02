package com.workspace.microservico2.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServices {
    @Autowired
    private RabbitTemplate rabbitMQServices;
    public void enviarMensagem(String nomeFila, String mensagem){
        this.rabbitMQServices.convertAndSend(nomeFila, mensagem);
    }
}
