import com.luanalinhares.retornoboleto.LeituraRetornoBancoBrasil;
import com.luanalinhares.retornoboleto.LeituraRetornoBradesco;
import com.luanalinhares.retornoboleto.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {

        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        final ProcessarBoletos processadorbradesco = new ProcessarBoletos(new LeituraRetornoBradesco());

        URI caminhoArquivoBrasil = Principal.class.getResource("banco-brasil-1.csv").toURI();
        URI caminhoArquivoBradesco = Principal.class.getResource("bradesco-1.csv").toURI();
        System.out.println("Lendo arquivo " + caminhoArquivoBrasil + "\n");
        System.out.println("Lendo arquivo " + caminhoArquivoBradesco + "\n");

        processador.processar(caminhoArquivoBrasil);
        processadorbradesco.processar(caminhoArquivoBradesco);
    }
}
