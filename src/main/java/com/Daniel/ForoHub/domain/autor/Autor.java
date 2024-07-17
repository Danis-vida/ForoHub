package com.Daniel.ForoHub.domain.autor;

import com.Daniel.ForoHub.domain.perfil.Perfil;
import com.Daniel.ForoHub.domain.respuestas.Respuestas;
import com.Daniel.ForoHub.domain.topicos.DatosRegistroTopico;
import com.Daniel.ForoHub.domain.topicos.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "autores")
@Entity(name = "Autor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private String contrasena;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @CollectionTable(name = "perfil_id")
//    private List<Perfil> perfil;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "topicos_id")
    private List<Topico> topicos;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "respuestas_id")
    private List<Respuestas> respuestas;


    public Autor(DatosAutorTopico datosAutorTopicoautor) {
        this.id = Long.valueOf(datosAutorTopicoautor.id());
        this.email = datosAutorTopicoautor.email();
        this.nombre = datosAutorTopicoautor.nombre();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
