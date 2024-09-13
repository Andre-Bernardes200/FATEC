package com.populateBD.demo.repository;

import com.populateBD.demo.entities.Dispositivo;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    @Transactional
    @Modifying
    @Query (value = "insert into ito1.dispositivo(nome,fk_id_usuario) values (?1,?2)", nativeQuery = true)
    void saveDisp(String nome, Long idUsuario);

    @Query("select d from Dispositivo d where d.nome = :nome and d.usuario.id = :idUsu")
    Optional<Dispositivo> findDisp (String nome, Long idUsu);
}
