package com.Daniel.ForoHub.domain.topicos;

import com.Daniel.ForoHub.domain.autor.Autor;
import com.Daniel.ForoHub.domain.curso.Curso;
import com.Daniel.ForoHub.domain.respuestas.Respuestas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "respuestas_id")
    private List<Respuestas> respuestas;

    public Topico(DatosRegistroTopico datosRegistroTopico) {

    }
}
