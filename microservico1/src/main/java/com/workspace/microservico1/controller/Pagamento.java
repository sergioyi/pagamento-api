package com.workspace.microservico1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Pagamento {

    private String url = "http://172.29.227.244:8081/notificar";

    @PostMapping("/pagar")
    public ResponseEntity<String> pagar(@RequestBody Double valor){
        
        RestTemplate rest = new RestTemplate();
        rest.postForObject(url, valor, String.class);

        return ResponseEntity.ok().body("o valor do pagamento foi: "+valor);
    }
}
