package org.example.service;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.example.DTO.GetHolerite;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PrefSJCService {


    public void extrairHoleriteMod1(GetHolerite caminho) {
        try {
            // Inicializa o PdfReader
            PdfReader reader = new PdfReader(caminho.caminho());

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
