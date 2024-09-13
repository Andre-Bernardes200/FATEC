package com.populateBD.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "dispositivo",schema = "ito1")
//@Table(name = "dispositivo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "fk_id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "id_localizacao")
    private List<Localizacao> localizacoes;
}

