package com.Daniel.ForoHub.domain.topicos;

import com.Daniel.ForoHub.domain.autor.Autor;
import com.Daniel.ForoHub.domain.autor.DatosAutorTopico;
import com.Daniel.ForoHub.domain.curso.Curso;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean estado,
        Autor autor,
        Curso curso

) {

    public DatosListadoTopicos(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getEstatus(),
                topico.getAutor(), topico.getCurso());
    }
}


