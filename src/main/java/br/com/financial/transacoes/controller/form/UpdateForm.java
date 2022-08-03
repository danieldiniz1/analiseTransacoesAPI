package br.com.financial.transacoes.controller.form;

public class UpdateForm {

    private String descricao;
    private String valor;

    public UpdateForm() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
