package org.example.controller;

import org.example.DTO.GetHolerite;
import org.example.service.PrefSJCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sjcextracao")
public class PrefSJCController {

    @Autowired
    private PrefSJCService prefSJCService;

    @GetMapping("/holeritemod1")
    public ResponseEntity<String> getPrefSJC(@RequestBody GetHolerite camainho) {

        prefSJCService.extrairHoleriteMod1(camainho);

        return ResponseEntity.ok().body("Extraído com sucesso");
    }
}
