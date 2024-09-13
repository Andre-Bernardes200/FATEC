package com.populateBD.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "usuario",schema = "ito1")
//@Table (name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
    private List<Dispositivo> dispositivos;
}
