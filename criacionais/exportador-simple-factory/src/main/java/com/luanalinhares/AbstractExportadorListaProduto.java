package com.luanalinhares;

import java.util.List;

public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {

    protected static final List<String> TITULOS_COLUNAS = List.of("ID", "Descrição", "Marca", "Modelo", "Estoque");

    @Override
    public final String exportar(List<Produto> listaProdutos) {
        final var sb = new StringBuilder();
        sb.append(abrirTabela())
                .append(abrirLinhaTitulos())
                .append(gerarColunasLinha(TITULOS_COLUNAS))
                .append(fecharLinhaTitulos());
        gerarLinhasProdutos(sb, listaProdutos);

        sb.append(fecharTabela());
        return sb.toString();
    }

    private void gerarLinhasProdutos(StringBuilder sb, List<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            List<String> valoresCamposProduto =
                    List.of(String.valueOf(produto.getId()),
                            produto.getDescricao(),
                            produto.getMarca(),
                            produto.getModelo(),
                            String.valueOf(produto.getEstoque()));
            sb.append(gerarColunasLinha(valoresCamposProduto));
        }
    }

    protected String gerarColunasLinha(List<String> valores) {
        final var sb = new StringBuilder("    ");
        sb.append(abrirLinha());
        for (String valor : valores) {
            sb.append(abrirColuna(valor))
                    .append(fecharColuna());
        }
        sb.append(fecharLinha());
        return sb.toString();
    }
}
