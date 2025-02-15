package com.Daniel.ForoHub.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {



    Page<Topico> findAll(Pageable paginacion);

//    @Query("""
//            select t
//            from Topico t
//            where t.estatus=:ver
//            """)
//    Page<Topico> findByEstatus(Boolean ver);


}
