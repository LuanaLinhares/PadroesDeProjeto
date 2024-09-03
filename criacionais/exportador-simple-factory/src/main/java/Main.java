

import com.luanalinhares.ExportadorListaProduto;
import com.luanalinhares.FormatoExportacao;
import com.luanalinhares.Produto;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        final var listaProdutos = List.of(
                new Produto("TV", "LG", "132-A", 120),
                new Produto("Notebook", "Asus", "New age", 341),
                new Produto("Smartphone", "Samsung", "Galaxy S10", 214)
        );

        final var exportadorPadrao = ExportadorListaProduto.newInstance(FormatoExportacao.HTML);
        System.out.println("Lista de Produtos em HTML\n");
        System.out.println(exportadorPadrao.exportar(listaProdutos));

        final var exportadorMarkdown = ExportadorListaProduto.newInstance(FormatoExportacao.MARKDOWN);
        System.out.println("Lista de Produtos em Markdown\n");
        System.out.println(exportadorMarkdown.exportar(listaProdutos));
    }
}