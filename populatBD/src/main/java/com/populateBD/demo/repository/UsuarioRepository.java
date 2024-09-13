package com.populateBD.demo.repository;

import com.populateBD.demo.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into ito1.usuario(id_usuario,nome) values (?1,?2)", nativeQuery = true)
    void saveNome(Long id, String nome);

    @Query("select u from Usuario u where u.id = :id")
    Optional<Usuario> findUsuario (Long id);
}
