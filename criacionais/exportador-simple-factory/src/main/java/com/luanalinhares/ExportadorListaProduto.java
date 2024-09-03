package com.luanalinhares;



import java.util.List;

public interface ExportadorListaProduto {
    String abrirTabela();
    String fecharTabela();
    String abrirLinha();
    String fecharLinha();
    String abrirLinhaTitulos();
    String fecharLinhaTitulos();
    String abrirColuna(String valor);
    String fecharColuna();
    String exportar(List<Produto> produtos);

    static ExportadorListaProduto newInstance(FormatoExportacao formato) {
        return switch (formato) {
            case HTML -> new ExportadorListaProdutoHtml();
            case MARKDOWN -> new ExportadorListaProdutoMarkdown();
            default -> throw new UnsupportedOperationException("Formato de arquivo não suportado: " + formato);
        };
    }
}

