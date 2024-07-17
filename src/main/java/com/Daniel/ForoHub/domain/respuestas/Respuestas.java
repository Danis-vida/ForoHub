package com.Daniel.ForoHub.domain.respuestas;

import com.Daniel.ForoHub.domain.autor.Autor;
import com.Daniel.ForoHub.domain.topicos.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuestas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;

    private String solucion;

    public Respuestas(DatosRespuesta datosRespuesta){
        this.mensaje = datosRespuesta.mensaje();
        this.fecha = LocalDateTime.now();
        this.solucion = datosRespuesta.solucion();
    }


}
