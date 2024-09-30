package com.workspace.microservico1.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServices {
    @Autowired
    private RabbitTemplate rabbitMQServices;
    public void enviarMensagem(String nomeFila, double mensagem){
        this.rabbitMQServices.convertAndSend(nomeFila, mensagem);
    }
}
