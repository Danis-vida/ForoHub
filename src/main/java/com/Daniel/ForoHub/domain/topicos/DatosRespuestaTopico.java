package com.Daniel.ForoHub.domain.topicos;

import com.Daniel.ForoHub.domain.autor.Autor;
import com.Daniel.ForoHub.domain.autor.DatosAutorTopico;
import com.Daniel.ForoHub.domain.curso.Curso;
import com.Daniel.ForoHub.domain.curso.DatosCursoTopico;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        LocalDateTime fechaCreacion,
        @NotBlank
        DatosAutorTopico autor,
        @NotBlank
        DatosCursoTopico curso
) {
}
