package com.programacao.prova1.service;

import com.programacao.prova1.dto.buscaralerta.AlertDTORequest;
import com.programacao.prova1.dto.buscaralerta.AlertDTOResponse;
import com.programacao.prova1.dto.cadastraralert.AlertRequest;
import com.programacao.prova1.dto.listalerta.AlertDTO;
import com.programacao.prova1.entities.AltAlerta;
import com.programacao.prova1.repository.AltAlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AltAlertaService {

    @Autowired
    AltAlertaRepository altAlertaRepository;

    public List<AlertDTO> listAlertas(){

        List<AltAlerta> list = altAlertaRepository.findAll();

        if(list.isEmpty()){
            throw new NoSuchElementException("Nenhum alerta encontrado");
        }

        for(AltAlerta alt : list){
            if(alt.getNivel() == null){
                alt.setNivel(5);
            }
        }

        List<AlertDTO> response = list.stream().map(AlertDTO::new).toList();

        return response;
    }

    public void cadastrarAlerta(AlertRequest request){

        AltAlerta alerta = new AltAlerta();

        if(request.dataHora() == null){
            alerta.setDataHora(LocalDateTime.now());
        }else {
            alerta.setDataHora(request.dataHora());
        }

        if(request.dataHoraVerificacao() != null){
            if(request.dataHoraVerificacao().toLocalTime().isAfter(request.dataHora().toLocalTime())){
                throw new IllegalArgumentException("A data hora de verificação é maior que a data hora, verifique!!");
            }
        }

        if(request.nivel() == null){
            alerta.setNivel(5);
        }

        alerta.setMensagem(request.mensagem());
        alerta.setDetalhe(request.detalhe());
        alerta.setNivel(request.nivel());

        altAlertaRepository.save(alerta);
    }

    public List<AlertDTOResponse> buscar(AlertDTORequest request){

        List<AltAlerta> list = altAlertaRepository.findByNivelLessThanAndMensagemContainingIgnoreCase(request.nivel(),request.palavra());

        if(list.isEmpty()){
            throw new NoSuchElementException("Nenhum trabalho encontrado com os parâmetros passados.");
        }

        List<AlertDTOResponse> response = list.stream().map(AlertDTOResponse::new).toList();

        return response;
    }
}
