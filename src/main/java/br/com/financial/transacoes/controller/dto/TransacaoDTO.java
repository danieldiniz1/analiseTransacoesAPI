package br.com.financial.transacoes.controller.dto;

import br.com.financial.transacoes.model.Transacao;

import java.util.Optional;

public class TransacaoDTO {

    private String id;
    private String descricao;
    private String tipoLancamento;
    private String categoria;
    private String valor;

    public TransacaoDTO() {
    }

    public TransacaoDTO(Transacao transacao) {
        setId(transacao.getId().toString());
        setDescricao(transacao.getDescricao());
        setTipoLancamento(transacao.getTipo().toString());
        setCategoria(transacao.getCategoria().toString());
        setValor(transacao.getValorTransacao().toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
