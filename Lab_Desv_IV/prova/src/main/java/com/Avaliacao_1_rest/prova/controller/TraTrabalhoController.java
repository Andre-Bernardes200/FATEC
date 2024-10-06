package com.Avaliacao_1_rest.prova.controller;

import com.Avaliacao_1_rest.prova.dto.buscar.BuscarRequest;
import com.Avaliacao_1_rest.prova.dto.buscar.BuscarResponse;
import com.Avaliacao_1_rest.prova.dto.cadastrar.TrabalhoCadastroRequest;
import com.Avaliacao_1_rest.prova.dto.listtrabalho.TrabalhoResponse;
import com.Avaliacao_1_rest.prova.service.TraTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalho")
public class TraTrabalhoController {

    @Autowired
    TraTrabalhoService traTrabalhoService;

    @GetMapping("/listar")
    public ResponseEntity<List<TrabalhoResponse>> listarTrabalhos(){
        List<TrabalhoResponse> response = traTrabalhoService.listarTrabalhos();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody TrabalhoCadastroRequest request){
        traTrabalhoService.cadastrar(request);

        return ResponseEntity.ok().body("Cadastrado com sucesso!!");
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<BuscarResponse>> buscar(@RequestBody BuscarRequest request){
        List<BuscarResponse> response = traTrabalhoService.buscar(request);

        return ResponseEntity.ok().body(response);

    }
}
