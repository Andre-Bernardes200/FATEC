package org.example.controller;

import org.example.DTO.HolertieMod1PrefSJC;
import org.example.service.PrefSJCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/sjcextracao")
public class PrefSJCController {

    @Autowired
    private PrefSJCService prefSJCService;

    @GetMapping("/holeritemod1")
    public ResponseEntity<String> getPrefSJC(@RequestBody HolertieMod1PrefSJC camainho) throws IOException {

        prefSJCService.extrairHoleriteMod1(camainho);

        return ResponseEntity.ok().body("Extraído com sucesso");
    }
}
