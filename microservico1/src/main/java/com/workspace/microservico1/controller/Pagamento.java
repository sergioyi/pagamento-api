package com.workspace.microservico1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pagamento {
    
    @Autowired
    private RabbitMQServices rabbitMQServices;

    @PostMapping("/pagar")
    public ResponseEntity<String> pagar(@RequestBody double valor){
        this.rabbitMQServices.enviarMensagem("filapagamento", valor);
        return ResponseEntity.ok().body("o valor do pagamento foi: "+valor);
    }
}
