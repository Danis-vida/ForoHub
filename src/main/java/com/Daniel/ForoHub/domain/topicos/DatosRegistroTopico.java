package com.Daniel.ForoHub.domain.topicos;

import com.Daniel.ForoHub.domain.autor.Autor;
import com.Daniel.ForoHub.domain.autor.DatosAutorTopico;
import com.Daniel.ForoHub.domain.curso.Curso;
import com.Daniel.ForoHub.domain.curso.DatosCursoTopico;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRegistroTopico(

        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,

        @JsonAlias("autor") DatosAutorTopico autor,

        @JsonAlias("curso") DatosCursoTopico curso
        //List<Topico> respuestas
) {
}
