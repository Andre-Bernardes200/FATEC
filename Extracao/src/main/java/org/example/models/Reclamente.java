package org.example.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Reclamente {

    public String nome;
    public String cargo;
    public String matricula;
    public String admissao;
    public String demissao;
    public List<Verbas> verbas;
}
