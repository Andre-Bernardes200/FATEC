package com.populateBD.demo.controller;

import com.populateBD.demo.dto.RequestDados;
import com.populateBD.demo.service.SalvarDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dados")
public class DadosController {

    @Autowired
    SalvarDados salvarDados;

    @PostMapping("/inserir")
    public ResponseEntity<String> insertDados(@RequestBody RequestDados caminhoTxt){
        salvarDados.salvarDados(caminhoTxt);
        return ResponseEntity.ok("Dados inseridos");
    }
}
