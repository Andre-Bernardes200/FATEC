package org.example.service;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.example.DTO.HolertieMod1PrefSJC;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PrefSJCService {


    public void extrairHoleriteMod1(HolertieMod1PrefSJC request) {
        try {
            // Inicializa o PdfReader
            PdfReader reader = new PdfReader(request.caminho());

            // Número total de páginas no PDF
            int numberOfPages = reader.getNumberOfPages();

            // Loop para ler e imprimir o conteúdo de cada página
            for (int i = 1; i <= numberOfPages; i++) {
                // Extraindo o texto da página
                String pageText = PdfTextExtractor.getTextFromPage(reader, i);
                System.out.println("Texto da página " + i + ":");
                System.out.println(pageText);
                System.out.println("=====================================");
            }

            // Fechar o reader
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
