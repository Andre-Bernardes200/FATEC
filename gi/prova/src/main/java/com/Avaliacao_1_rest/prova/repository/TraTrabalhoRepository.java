package com.Avaliacao_1_rest.prova.repository;

import com.Avaliacao_1_rest.prova.entities.TraTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TraTrabalhoRepository extends JpaRepository<TraTrabalho,Integer> {

    @Query("select t from TraTrabalho t where t.nota > :nota and lower(t.titulo) like %:palavra%")
    List<TraTrabalho> findByNotaAndPalavra(Integer nota, String palavra);
}
