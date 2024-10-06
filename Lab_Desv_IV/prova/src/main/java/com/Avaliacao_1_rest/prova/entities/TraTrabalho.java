package com.Avaliacao_1_rest.prova.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table (name = "tra_trabalho")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TraTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tra_id")
    private Integer idTra;

    @Column(name = "tra_titulo")
    private String titulo;

    @Column(name = "tra_data_hora_entrega")
    private Timestamp dataHoraEntrega;

    @Column(name = "tra_descricao")
    private String descricao;

    @Column(name = "tra_grupo")
    private String grupo;

    @Column(name = "tra_nota")
    private Integer nota;

    @Column(name = "tra_justificativa")
    private String justificativa;

}
