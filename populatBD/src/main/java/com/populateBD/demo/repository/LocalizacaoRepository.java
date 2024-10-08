package com.populateBD.demo.repository;

import com.populateBD.demo.entities.Localizacao;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Repository
public interface LocalizacaoRepository extends JpaRepository <Localizacao,Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into ito1.localizacao (latitude, longitude,data_hora,fk_id_dispositivo,id_base_cliente) values (?1, ?2, ?3,?4,?5)", nativeQuery = true)
    void insertLocal(Double latitude, Double longitude, Timestamp dataHora, Long idDispositivo, String idBase);
}
