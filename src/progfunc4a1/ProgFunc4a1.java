
package progfunc4a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class MyException extends IOException {
    int linhaErro;
    MyException(int linhaErro) {
        this.linhaErro = linhaErro;
    }
    int getLinhaErro() {
        return linhaErro;
    }
}

public class ProgFunc4a1 {

    public void iniciaJogo() throws MyException, IOException {
        
        Scanner leitor = null;
        
        try {
            
            leitor = new Scanner(new File("teste.txt"));
            
            int nrLinha = 0;
            
            while(leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(":");
                nrLinha++;
                
                if(dados.length > 5) {
                    throw new MyException(nrLinha);
                }
            }
        }
        catch(FileNotFoundException ex) {
            throw new IOException();
        }
        
    }
    
    public static void main(String[] args) {
        
	// o visualizador trata desta parte :)

        try {
		iniciaJogo();
	}
	catch(MyException ex) {
		System.out.println("Erro na linha " + ex.getLinhaErro());
	}
        catch(IOException ex) {
		System.out.println("Erro ao ler o ficheiro");
	}

    }
    
}
