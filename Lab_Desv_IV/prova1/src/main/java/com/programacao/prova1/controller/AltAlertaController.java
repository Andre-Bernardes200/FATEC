package com.programacao.prova1.controller;

import com.programacao.prova1.dto.buscaralerta.AlertDTORequest;
import com.programacao.prova1.dto.buscaralerta.AlertDTOResponse;
import com.programacao.prova1.dto.cadastraralert.AlertRequest;
import com.programacao.prova1.dto.listalerta.AlertDTO;
import com.programacao.prova1.service.AltAlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerta")
public class AltAlertaController {

    @Autowired
    AltAlertaService altAlertaService;

    @GetMapping("/listar")
    public ResponseEntity<List<AlertDTO>> listAlerta(){

        return ResponseEntity.ok().body(altAlertaService.listAlertas());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarAlert(@RequestBody AlertRequest request){

        altAlertaService.cadastrarAlerta(request);

        return ResponseEntity.ok().body("Cadastrado com sucesso!!");
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<AlertDTOResponse>> buscarAlerta(@RequestBody AlertDTORequest request){

        List<AlertDTOResponse> response = altAlertaService.buscar(request);

        return ResponseEntity.ok().body(response);
    }
}
