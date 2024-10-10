package com.programacao.prova1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "alt_alerta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AltAlerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alt_id")
    private Long id;

    @Column(name = "alt_mensagem")
    private String mensagem;

    @Column(name = "alt_detalhe")
    private String detalhe;

    @Column(name = "alt_data_hora")
    private LocalDateTime dataHora;

    @Column(name = "alt_data_hora_verificacao")
    private LocalDateTime dataHoraVerificacao;

    @Column(name = "alt_nivel")
    private Integer nivel;

}
