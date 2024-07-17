package com.Daniel.ForoHub.domain.curso;

import com.Daniel.ForoHub.domain.topicos.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String categoria;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "topicos_id")
    private List<Topico> topicos;

    public Curso(DatosCursoTopico datosCursoTopico) {
        this.id = datosCursoTopico.id();
        this.nombre = datosCursoTopico.nombre();
        this.categoria = datosCursoTopico.categoria();
    }
}
