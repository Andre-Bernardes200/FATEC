package com.Avaliacao_1_rest.prova.dto.buscar;

import com.Avaliacao_1_rest.prova.entities.TraTrabalho;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BuscarResponse(@JsonAlias("id") Integer id,
                             @JsonAlias("titulo") String titulo,
                             @JsonAlias("diaEntrega") Timestamp dataHoraEntrega,
                             @JsonAlias("descricao") String descricao,
                             @JsonAlias("grupo") String grupo,
                             @JsonAlias("nota") Integer nota,
                             @JsonAlias("justificativa") String justificativa) {

    public BuscarResponse(TraTrabalho trabalho){
        this(trabalho.getIdTra(),trabalho.getTitulo(),trabalho.getDataHoraEntrega(),trabalho.getDescricao(),trabalho.getGrupo(),trabalho.getNota(),trabalho.getJustificativa());
    }
}
