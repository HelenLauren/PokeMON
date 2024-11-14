package com.pokemon.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
    private final String caminhoArquivo;

    public FileManager(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    // Método para ler o conteúdo do arquivo como uma única String
    public String lerArquivoComoString() throws FileNotFoundException {
        StringBuilder conteudo = new StringBuilder();
        File file = new File(caminhoArquivo);
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                conteudo.append(scanner.nextLine()).append("\n");
            }
        }
        
        return conteudo.toString();
    }
}
