package com.populateBD.demo.service;

import com.populateBD.demo.dto.RequestDados;
import com.populateBD.demo.entities.Dispositivo;
import com.populateBD.demo.entities.Localizacao;
import com.populateBD.demo.entities.Usuario;
import com.populateBD.demo.repository.DispositivoRepository;
import com.populateBD.demo.repository.LocalizacaoRepository;
import com.populateBD.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.Duration;

@Service
public class SalvarDados {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    DispositivoRepository dispositivoRepository;

    @Autowired
    LocalizacaoRepository localizacaoRepository;

    public void salvarDados1A1(RequestDados caminhoArquivo) {
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo.caminho()))) {
            br.readLine();
            int cont = 0;
            LocalDateTime tempoAgr = null;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");
                Long idUsuario = Long.valueOf(dados[5]);
                String nomeDisp = "CARD";
                String nome = dados[4];

                Optional<Usuario> usuario = localizarUsuario(idUsuario,nome);
                if(usuario.isPresent()){

                    Optional<Dispositivo> dispositivo = localizarDisp(nomeDisp, usuario.get().getId());

                    if(dispositivo.isPresent()){
                        Long idDisp = dispositivo.get().getId();
                        String idBase = dados[0];
                        String latitude = dados[2];
                        String longitude = dados[3];

                        latitude = latitude.replace(",",".");
                        longitude = longitude.replace(",",".");


                        if(latitude.matches(".\\d+")){
                            latitude = 0+ latitude;
                        }

                        String dadoSeparado = dados[1].split("\\.")[0];

                        if(cont == 0){
                            tempoAgr = LocalDateTime.now();
                        }
                        localizacaoRepository.insertLocal(Double.valueOf(latitude),Double.valueOf(longitude), Timestamp.valueOf(dadoSeparado), idDisp,idBase);

                        if(cont ==999){
                            LocalDateTime tempoDepois = LocalDateTime.now();
                            Duration duracao = Duration.between(tempoAgr, tempoDepois);
                            long tempoInsercao = duracao.toMillis();
                            System.out.println("Tempo inicio: " + tempoAgr + " Tempo finalização: " + tempoDepois);
                            System.out.println("Tempo inserção: " + tempoInsercao);
                            cont = 0;
                        }

                        cont++;
                    }else{
                        System.out.print("Erro ao localizar dispositivo na aplicação");
                    }
                }else{
                    System.out.print("Erro ao localizar usuário na aplicação");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarDadosLote(RequestDados caminhoArquivo) {
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo.caminho()))) {
            br.readLine();
            int cont = 0;
            List<Localizacao> loteInsert = new ArrayList<>();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\\|");
                Long idUsuario = Long.valueOf(dados[5]);
                String nomeDisp = "CARD";
                String nome = dados[4];

                Optional<Usuario> usuario = localizarUsuario(idUsuario,nome);
                if(usuario.isPresent()){

                    Optional<Dispositivo> dispositivo = localizarDisp(nomeDisp, usuario.get().getId());

                    if(dispositivo.isPresent()){
                        String idBase = dados[0];
                        String latitude = dados[2];
                        String longitude = dados[3];

                        latitude = latitude.replace(",",".");
                        longitude = longitude.replace(",",".");


                        if(latitude.matches(".\\d+")){
                            latitude = 0+ latitude;
                        }

                        String dadoSeparado = dados[1].split("\\.")[0];

                        Localizacao localNovo = new Localizacao(Double.valueOf(latitude),Double.valueOf(longitude), Timestamp.valueOf(dadoSeparado.split(",")[0]), dispositivo.get(),idBase);
                        loteInsert.add(localNovo);
                        if(cont == 1000){
                            LocalDateTime tempoAgr = LocalDateTime.now();
                            localizacaoRepository.saveAll(loteInsert);
                            loteInsert.clear();
                            LocalDateTime tempoDepois = LocalDateTime.now();

                            Duration duracao = Duration.between(tempoAgr, tempoDepois);
                            long tempoInsercao = duracao.toMillis();
                            System.out.println("Tempo inicio: " + tempoAgr + " Tempo finalização: " + tempoDepois);
                            System.out.println("Tempo inserção: " + tempoInsercao);
                            cont = 0;
                        }
                        cont ++;

                    }else{
                        System.out.print("Erro ao localizar dispositivo na aplicação");
                    }
                }else{
                    System.out.print("Erro ao localizar usuário na aplicação");
                }

            }
            localizacaoRepository.saveAll(loteInsert);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public Optional<Usuario> localizarUsuario (Long idUsuario,String nome) {

        Optional<Usuario> idUsuLocalizado = usuarioRepository.findUsuario(idUsuario);

        if(idUsuLocalizado.isPresent()){
            return idUsuLocalizado;
        }else{
            usuarioRepository.saveNome(idUsuario, nome);
            idUsuLocalizado = usuarioRepository.findUsuario(idUsuario);
            return idUsuLocalizado;
        }
    }

    @Transactional
    public Optional<Dispositivo> localizarDisp (String nomeDisp,Long idUsuario) {

        Optional<Dispositivo> idDisp = dispositivoRepository.findDisp(nomeDisp,idUsuario);

        if(idDisp.isPresent()){
            return idDisp;
        }else{
            dispositivoRepository.saveDisp(nomeDisp, idUsuario);
            idDisp = dispositivoRepository.findDisp(nomeDisp,idUsuario);
            return idDisp;
        }
    }
}
