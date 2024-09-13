package com.populateBD.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "localizacao",schema = "ito1")
//@Table(name = "localizacao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localizacao")
    private Long id;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "data_hora")
    private Timestamp dataHora;

    @Column(name = "id_base_cliente")
    private String base;

    @ManyToOne
    @JoinColumn(name = "fk_id_dispositivo", nullable = false)
    private Dispositivo id_dispositivo;

    public Localizacao(Double latitude, Double longitude, Timestamp dataSql, Dispositivo dispositivo, String idBase) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataHora = dataSql;
        this.id_dispositivo = dispositivo;
        this.base = idBase;
    }
}
