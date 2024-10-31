package PokeMON.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
    private String caminhoArqivo;

    public FileManager(String caminhoArqivo){
        this.caminhoArqivo = caminhoArqivo;
    }

    public void lerArquivoScanner(){
        File file = new File(caminhoArqivo);
        try {
            Scanner scanner = new Scanner(file);
            String texto = scanner.nextLine();
            System.out.println(texto);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
