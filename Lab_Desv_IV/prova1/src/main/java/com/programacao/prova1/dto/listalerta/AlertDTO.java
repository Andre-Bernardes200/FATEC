package com.programacao.prova1.dto.listalerta;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.programacao.prova1.entities.AltAlerta;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AlertDTO(@JsonAlias("id") Long id,
                       @JsonAlias("mensagem") String mensagem,
                       @JsonAlias("detalhe") String detalhe,
                       @JsonAlias("dataHora") LocalDateTime dataHora,
                       @JsonAlias("dataHoraVerificacao") LocalDateTime dataHoraVerificacao,
                       @JsonAlias("nivel") int nivel) {

    public AlertDTO(AltAlerta alt){
        this(alt.getId(), alt.getMensagem(), alt.getDetalhe(), alt.getDataHora(),alt.getDataHoraVerificacao(),alt.getNivel());
    }
}