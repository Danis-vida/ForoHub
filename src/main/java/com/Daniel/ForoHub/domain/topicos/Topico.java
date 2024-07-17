package com.Daniel.ForoHub.domain.topicos;

import com.Daniel.ForoHub.domain.autor.Autor;
import com.Daniel.ForoHub.domain.curso.Curso;
import com.Daniel.ForoHub.domain.respuestas.DatosRespuesta;
import com.Daniel.ForoHub.domain.respuestas.Respuestas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "respuestas_id")
    private List<Respuestas> respuestas;

    private Boolean estatus;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = new Autor(datosRegistroTopico.autor());
        this.estatus = true;
        this.curso = new Curso(datosRegistroTopico.curso());
        this.estatus = true;
        this.respuestas = new ArrayList<>();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        this.titulo = datosActualizarTopico.titulo();
        this.mensaje = datosActualizarTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = new Autor(datosActualizarTopico.autor());
        this.estatus = true;
        this.curso = new Curso(datosActualizarTopico.curso());
        this.estatus = true;
        //this.respuestas = new ArrayList<>();
    }

    public void desactivarTopico() {
        this.estatus = false;
    }
}
