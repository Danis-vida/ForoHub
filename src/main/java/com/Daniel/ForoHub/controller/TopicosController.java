package com.Daniel.ForoHub.controller;

import com.Daniel.ForoHub.domain.topicos.DatosRegistroTopico;
import com.Daniel.ForoHub.domain.topicos.Topico;
import com.Daniel.ForoHub.domain.topicos.TopicoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
//@SecurityRequirement(name = "bearer-key")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    @Operation(summary = "Registra un nuevo topico en la base de datos")
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));

    }
}
