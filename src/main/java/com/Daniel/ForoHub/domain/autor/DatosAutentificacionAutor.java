package com.Daniel.ForoHub.domain.autor;

import com.Daniel.ForoHub.domain.perfil.Perfil;

import java.util.List;

public record DatosAutentificacionAutor(
        Long id,
        String nombre,
        String email,
        String contrasena,
        List<Perfil> perfil
) {

}
