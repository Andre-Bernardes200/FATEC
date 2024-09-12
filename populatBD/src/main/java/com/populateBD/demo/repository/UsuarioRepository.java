package com.populateBD.demo.repository;

import com.populateBD.demo.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into usuario(nome) values (1?)", nativeQuery = true)
    void saveNome(String nome);

    @Query("select u.id from Usuario u where u.nome = :nome")
    Long findIdUsuario (String nome);
}
