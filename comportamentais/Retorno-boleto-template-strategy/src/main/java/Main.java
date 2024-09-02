import com.luanalinhares.retornoboleto.LeituraRetornoBancoBrasil;
import com.luanalinhares.retornoboleto.LeituraRetornoBradesco;
import com.luanalinhares.retornoboleto.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        // Processa arquivo do Banco do Brasil
        final var processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());

        URI caminhoArquivo = Main.class.getResource("banco-brasil-1.csv").toURI();
        System.out.println("Lendo arquivo Banco do Brasil " + caminhoArquivo + "\n");
        processador.processar(caminhoArquivo);


        // Processa arquivo do Bradesco
        final var processadorBradesco = new ProcessarBoletos(new LeituraRetornoBradesco());
        URI caminhoArquivoBradesco = Main.class.getResource("bradesco-1.csv").toURI();
        System.out.println("Lendo arquivo do Bradesco " + caminhoArquivoBradesco + "\n");
        processadorBradesco.processar(caminhoArquivoBradesco);
    }
}