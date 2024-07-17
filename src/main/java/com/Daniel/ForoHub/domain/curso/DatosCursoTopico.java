package com.Daniel.ForoHub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCursoTopico(
        Long id,
        String nombre,
        String categoria
) {
}
