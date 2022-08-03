package br.com.financial.transacoes.controller.dto;

import br.com.financial.transacoes.model.enums.Categoria;
import br.com.financial.transacoes.model.enums.Conta;
import br.com.financial.transacoes.model.enums.Tipo;

public class TransacaoCriadaDTO {

    private String id;
    private Categoria categoria;
    private Tipo tipo;
    private Conta conta;

    public TransacaoCriadaDTO() {
    }

    public TransacaoCriadaDTO(String id, Categoria categoria, Tipo tipo, Conta conta) {
        this.id = id;
        this.categoria = categoria;
        this.tipo = tipo;
        this.conta = conta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
