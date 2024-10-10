package com.programacao.prova1.dto.buscaralerta;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AlertDTORequest(@JsonAlias("palavra") String palavra,
                              @JsonAlias("nivel") Integer nivel) {
}
