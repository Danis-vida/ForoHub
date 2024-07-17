package com.Daniel.ForoHub.domain.autor;

import jakarta.validation.constraints.NotBlank;

public record DatosAutorTopico(
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        String email
) {
}
