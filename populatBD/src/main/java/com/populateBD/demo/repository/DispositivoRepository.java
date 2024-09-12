package com.populateBD.demo.repository;

import com.populateBD.demo.entities.Dispositivo;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    @Transactional
    @Modifying
    @Query (value = "insert into dispositivo(nome) values (?1)", nativeQuery = true)
    void saveDisp(String nome);

    @Query("select d.id from Dispositivo d where d.nome = :nome")
    Long findIdDisp (String nome);
}
