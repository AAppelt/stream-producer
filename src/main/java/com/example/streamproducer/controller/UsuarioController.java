package com.example.streamproducer.controller;

import com.example.streamproducer.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Source.class)
public class UsuarioController {

    @Autowired
    private MessageChannel output;

    @PostMapping("/cadastrar")
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        output.send(MessageBuilder.withPayload(usuario).build());

        return usuario;
    }
    
}