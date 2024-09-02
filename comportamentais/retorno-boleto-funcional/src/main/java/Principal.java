import com.luanalinhares.retornoboleto.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        // Processa o arquivo do Banco do Brasil
        var processadorBancoBrasil = new ProcessarBoletos(ProcessarBoletos::lerBancoBrasil);
        URI caminhoArquivoBrasil = Principal.class.getResource("banco-brasil-1.csv").toURI();
        processadorBancoBrasil.processar(caminhoArquivoBrasil);

        // Processa o arquivo do Bradesco
        var processadorBradesco = new ProcessarBoletos(ProcessarBoletos::lerBradesco);
        URI caminhoArquivoBradesco = Principal.class.getResource("bradesco-1.csv").toURI();
        processadorBradesco.processar(caminhoArquivoBradesco);
    }
}
