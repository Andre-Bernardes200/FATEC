package com.Avaliacao_1_rest.prova.service;

import com.Avaliacao_1_rest.prova.dto.buscar.BuscarRequest;
import com.Avaliacao_1_rest.prova.dto.buscar.BuscarResponse;
import com.Avaliacao_1_rest.prova.dto.cadastrar.TrabalhoCadastroRequest;
import com.Avaliacao_1_rest.prova.dto.listtrabalho.TrabalhoResponse;
import com.Avaliacao_1_rest.prova.entities.TraTrabalho;
import com.Avaliacao_1_rest.prova.repository.TraTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TraTrabalhoService {

    @Autowired
    TraTrabalhoRepository traTrabalhoRepository;

    public List<TrabalhoResponse> listarTrabalhos(){

        List<TraTrabalho> list = traTrabalhoRepository.findAll();

        if(list.isEmpty()){
            throw new NoSuchElementException("Nenhum trabalho encontrado, sua lista está vazia");
        }

        List<TrabalhoResponse> trabalhos = list.stream().map(TrabalhoResponse::new).toList();
        return trabalhos;
    }

    @Transactional
    public void cadastrar(TrabalhoCadastroRequest request){

        if(request.titulo().isEmpty() || request.titulo().isBlank() || request.grupo().isBlank() || request.grupo().isEmpty()){
            throw new IllegalArgumentException("O Campo título ou grupo está em branco, por favor preenche-lo");
        }

        TraTrabalho trabalho = new TraTrabalho();

        trabalho.setTitulo(request.titulo());

        if(request.dataHoraEntrega() == null || request.dataHoraEntrega().toLocalDateTime().toString().isBlank()){
            trabalho.setDataHoraEntrega(Timestamp.valueOf(LocalDateTime.now()));
        }else{
            trabalho.setDataHoraEntrega(request.dataHoraEntrega());
        }

        trabalho.setDescricao(request.descricao());
        trabalho.setGrupo(request.grupo());
        trabalho.setNota(request.nota());
        trabalho.setJustificativa(request.justificativa());

        traTrabalhoRepository.save(trabalho);
    }

    public List<BuscarResponse> buscar(BuscarRequest request){

        List<TraTrabalho> list = traTrabalhoRepository.findByNotaAndPalavra(request.nota(),request.palavra().toLowerCase());

        if(list.isEmpty()){
            throw new NoSuchElementException("Nenhum trabalho encontrado com os parâmetros passados.");
        }

        List<BuscarResponse> response = list.stream().map(BuscarResponse::new).toList();

        return response;

    }
}
