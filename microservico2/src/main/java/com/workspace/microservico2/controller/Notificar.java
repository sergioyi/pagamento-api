package com.workspace.microservico2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.workspace.microservico2.services.RabbitMQServices;

@RestController
public class Notificar {

    @Autowired
    private RabbitMQServices rabbitMQServices;

    @PostMapping("/notificar")
    public void notificar (@RequestBody Double valor){
        System.out.println("O valor foi de: "+valor);
        this.rabbitMQServices.enviarMensagem("topicopagamento", "Notificação: pagamento de "+valor+" foi realizado !");
    }
}
