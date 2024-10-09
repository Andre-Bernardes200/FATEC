package com.Avaliacao_1_rest.prova.dto.cadastrar;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TrabalhoCadastroRequest(@JsonAlias("titulo") String titulo,
                                      @JsonAlias("diaEntrega") Timestamp dataHoraEntrega,
                                      @JsonAlias("descricao") String descricao,
                                      @JsonAlias("grupo") String grupo,
                                      @JsonAlias("nota") Integer nota,
                                      @JsonAlias("justificativa") String justificativa) {
}
