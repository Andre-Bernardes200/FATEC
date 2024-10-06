package com.Avaliacao_1_rest.prova.dto.buscar;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BuscarRequest(@JsonAlias("nota") Integer nota,
                            @JsonAlias("palavra") String palavra) {
}
