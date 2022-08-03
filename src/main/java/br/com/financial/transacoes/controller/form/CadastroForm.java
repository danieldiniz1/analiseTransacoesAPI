package br.com.financial.transacoes.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CadastroForm {

    @NotNull(message = "o valor não pode ser nulo")
    @NotBlank(message = "valor inválido")
    @Size(min = 3, max = 255)
    private String valor;
    @NotNull(message = "o descrição não pode ser nulo")
    @NotBlank(message = "descrição inválida")
    @Size(min = 3, max = 255)
    private String descricao;
    @NotNull(message = "Data de lançamento não pode ser nulo")
    @NotBlank(message = "Data de lançamento inválida - data deve estar no formado yyyy/MM/dd")
    @Size(min = 10, max = 11)
    private String dataLancamento;
    @NotNull(message = "categoria pode ser nulo")
    @NotBlank(message = "categoria inválida")
    @Size(min = 1, max = 2)
    private String categoria;
    @NotNull(message = "o código de conta não pode ser nulo")
    @NotBlank(message = "código de conta inválida")
    @Size(min = 1, max = 2)
    private String conta;

    public CadastroForm() {
    }

    public CadastroForm(CadastroForm cadastroForm) {
        this.valor = cadastroForm.getValor();
        this.descricao = cadastroForm.getDescricao();
        this.dataLancamento = cadastroForm.getDataLancamento();
        this.categoria = cadastroForm.getCategoria();
        this.conta = cadastroForm.getConta();
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}
