package com.programacao.prova1.dto.cadastraralert;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AlertRequest(@JsonAlias("mensagem") String mensagem,
                           @JsonAlias("detalhe") String detalhe,
                           @JsonAlias("dataHora") LocalDateTime dataHora,
                           @JsonAlias("dataHoraVerificacao") LocalDateTime dataHoraVerificacao,
                           @JsonAlias("nivel") Integer nivel) {
}
