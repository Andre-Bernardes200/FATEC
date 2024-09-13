package com.populateBD.demo.controller;

import com.populateBD.demo.dto.RequestDados;
import com.populateBD.demo.entities.Usuario;
import com.populateBD.demo.repository.UsuarioRepository;
import com.populateBD.demo.service.SalvarDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dados")
public class DadosController {

    @Autowired
    SalvarDados salvarDados;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/inserir")
    public ResponseEntity<String> insertDados(@RequestBody RequestDados caminhoTxt){
        salvarDados.salvarDadosLote(caminhoTxt);
        return ResponseEntity.ok("Dados inseridos");
    }

}
