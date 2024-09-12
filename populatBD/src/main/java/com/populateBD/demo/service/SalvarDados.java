package com.populateBD.demo.service;

import com.populateBD.demo.dto.RequestDados;
import com.populateBD.demo.repository.DispositivoRepository;
import com.populateBD.demo.repository.LocalizacaoRepository;
import com.populateBD.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class SalvarDados {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    DispositivoRepository dispositivoRepository;

    @Autowired
    LocalizacaoRepository localizacaoRepository;

    public void salvarDados(RequestDados caminhoArquivo) {
        String linha;
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo.caminho()))) {
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");
                System.out.println(dados[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
