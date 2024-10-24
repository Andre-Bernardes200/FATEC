package org.example.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HolertieMod1PrefSJC(@JsonAlias("caminho") String caminho) {
}
