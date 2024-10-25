package org.example.service;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.example.DTO.HolertieMod1PrefSJC;
import org.example.models.Reclamente;
import org.example.models.Verbas;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PrefSJCService {


    public void extrairHoleriteMod1(HolertieMod1PrefSJC request) throws IOException {

        List<Reclamente> listaReclamantes = new ArrayList<>();

        try {
            // Inicializa o PdfReader
            PdfReader reader = new PdfReader(request.caminho());

            // Número total de páginas no PDF
            int qtdPaginas = reader.getNumberOfPages();

            String nome = "";
            String matricula = "";
            String mes = "";
            List<Verbas> verbas = new ArrayList<>();
            Boolean salvar = false;
            Boolean salvouVerba = false;

            // Loop para ler e imprimir o conteúdo de cada página
            for (int i = 1; i <= qtdPaginas; i++) {
                double porcentagem = Math.floor(((double) i / qtdPaginas) * 100);

                System.out.println(porcentagem);

                // Extraindo o texto da página
                String pageText = PdfTextExtractor.getTextFromPage(reader, i);
                System.out.print(pageText);

                List<String> linhas = Arrays.stream(pageText.split("\n")).toList();

                int qtdLinhas = linhas.size();

                for (int j = 0; j < qtdLinhas; j++){

                    String linha = linhas.get(j);

                    String matriculaRegex = "(?<matricula>\\d{6})\\/(?<contrato>\\d)\\s+(?<cpf>\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})\\s+(?<admissao>\\d{2}\\/\\d{2}\\/\\d{4})\\s+(?<departamento>\\d+)\\s+(?<periodo>\\w+\\/\\d{4})\\s+(?<folha>\\d{2}\\/\\d{2})$";
                    Pattern patternMatricula = Pattern.compile(matriculaRegex);
                    Matcher matchMatricula = patternMatricula.matcher(linha);

                    String verbaRegex = "(?<codigo>\\d+/\\d+)\\s+(?<descricao>.+?)\\s+(?<competencia>\\d{2}/\\d{4})\\s+(?<quantidade>[\\d,]+%?\\s+)?(?<valor>\\d{1,3}(?:\\.\\d{3})*(?:,\\d{2}))";
                    Pattern patternVerba = Pattern.compile(verbaRegex);
                    Matcher matchVerba = patternVerba.matcher(linha);

                    String salvarRegex = "^Este documento é cópia do original,";
                    Pattern patternSalvar = Pattern.compile(salvarRegex);
                    Matcher matchSalvar = patternSalvar.matcher(linha);

                    if(matchMatricula.find()){
                        String numeroMatricula = matchMatricula.group("matricula");
                        String contrato = matchMatricula.group("contrato");
                        matricula = numeroMatricula + "/" + contrato;
                        nome = linhas.get(j+1);
                        mes = matchMatricula.group("periodo");
                    }

                    if(matchVerba.find()){
                        Verbas verba = new Verbas();
                        verba.setCodigo(matchVerba.group("codigo"));
                        verba.setNome(matchVerba.group("descricao"));
                        verba.setMes(mes);
                        verba.setCompetencia(matchVerba.group("competencia"));
                        verba.setReferencia(matchVerba.group("quantidade"));
                        verba.setValor(matchVerba.group("valor"));
                        verbas.add(verba);
                        salvouVerba = true;
                    }

                    if(matchSalvar.find()){
                        salvar = true;
                    }

                    if(!nome.isBlank() && !nome.isEmpty() && !matricula.isEmpty() && !matricula.isBlank()
                    && !mes.isEmpty() && ! mes.isBlank() && salvar) {

                        Reclamente reclamente = new Reclamente();
                        reclamente.setNome(nome);
                        reclamente.setMatricula(matricula);
                        reclamente.setVerbas(verbas);

                        listaReclamantes.add(reclamente);

                        nome = "";
                        matricula = "";
                        mes = "";
                        verbas = new ArrayList<>();
                        salvar = false;

                    }
                }

            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(!listaReclamantes.isEmpty()){
            StringBuilder info = new StringBuilder();

            //Adicionar a primeira linha, que será o cabeçalho do txt
            info.append("Matricula;Nome;Verba;Mês;competencia;quantidade;valor");

            for(Reclamente r : listaReclamantes){
                for(Verbas v : r.verbas){
                    info.append(r.getMatricula() + ";" + r.getNome() + ";" + v.getMes() + ";"+ v.getCodigo() + ";" + v.getNome() + ";" + v.getCompetencia() + ";" + v.getReferencia() + ";" + v.getValor());
                }
            }

            //Define o nome do arquivo txt+
            String arquivoFinal = request.caminho().replace(".pdf", ".txt");

            Files.write(Paths.get(arquivoFinal), info.toString().getBytes());

        }

    }

}
