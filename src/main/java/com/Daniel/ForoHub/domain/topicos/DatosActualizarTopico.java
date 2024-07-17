package com.Daniel.ForoHub.domain.topicos;

import com.Daniel.ForoHub.domain.autor.DatosAutorTopico;
import com.Daniel.ForoHub.domain.curso.DatosCursoTopico;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DatosActualizarTopico(
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
