package com.programacao.prova1.repository;

import com.programacao.prova1.entities.AltAlerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AltAlertaRepository extends JpaRepository<AltAlerta,Long> {

    @Query("select a from AltAlerta a where a.nivel < :nivel and lower(a.mensagem) like %:palavra%")
    List<AltAlerta> findByPalavraAndNivel(Integer nivel, String palavra);

    List<AltAlerta> findByNivelLessThanAndMensagemContainingIgnoreCase(Integer nivel, String mensagem);
}
