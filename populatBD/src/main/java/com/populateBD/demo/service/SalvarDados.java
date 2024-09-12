package com.populateBD.demo.service;

import com.populateBD.demo.dto.RequestDados;
import com.populateBD.demo.entities.Dispositivo;
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
import java.util.Optional;

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
            br.readLine();
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
                        String latitude = dados[2];
                        String longitude = dados[3];

                        latitude = latitude.replace(",",".");
                        longitude = longitude.replace(",",".");


                        if(latitude.matches(".\\d+")){
                            latitude = 0+ latitude;
                        }

                        Timestamp data = Timestamp.valueOf(dados[1].split("\\.")[0]);

                        localizacaoRepository.insertLocal(Double.valueOf(latitude),Double.valueOf(longitude), data,idDisp);


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
