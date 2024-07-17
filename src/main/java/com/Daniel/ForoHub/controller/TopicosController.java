package com.Daniel.ForoHub.controller;

import com.Daniel.ForoHub.domain.autor.DatosAutorTopico;
import com.Daniel.ForoHub.domain.curso.DatosCursoTopico;
import com.Daniel.ForoHub.domain.topicos.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    @Operation(summary = "Registra un nuevo topico en la base de datos")
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                new DatosAutorTopico(topico.getId(), topico.getAutor().getNombre(), topico.getAutor().getEmail()),
                new DatosCursoTopico(topico.getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()));

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);

    }

//    @GetMapping
//    @Operation(summary = "Obtiene el listado de topicos")
//    public ResponseEntity<List<DatosListadoTopicos>> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
//        return (ResponseEntity<List<DatosListadoTopicos>>) topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
//       // return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new));
//    }

    @GetMapping
    public List<Topico> getAllTopicos() {
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    @Transactional
    @Operation(summary = "Muestra topico por id")
    public ResponseEntity muestraTopicoPorId(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico =  new DatosRespuestaTopico(
                topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                new DatosAutorTopico(topico.getId(), topico.getAutor().getNombre(), topico.getAutor().getEmail()),
                new DatosCursoTopico(topico.getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()));

        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Actualiza los datos de un topico existente")
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico
                                                                             datosActualizarTopico, @PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                new DatosAutorTopico(topico.getId(), topico.getAutor().getNombre(), topico.getAutor().getEmail()),
                new DatosCursoTopico(topico.getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria())));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina un medico registrado - inactivo")
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

}
