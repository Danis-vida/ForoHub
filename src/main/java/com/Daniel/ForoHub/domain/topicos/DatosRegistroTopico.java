package com.Daniel.ForoHub.domain.topicos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        @Future
        LocalDateTime fechaCreacion,
        @NotBlank
        String autor,
        @NotBlank
        String curso
        //List<Topico> respuestas
) {
}
