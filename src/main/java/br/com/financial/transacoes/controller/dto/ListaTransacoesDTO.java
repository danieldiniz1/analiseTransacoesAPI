package br.com.financial.transacoes.controller.dto;

import br.com.financial.transacoes.model.Transacao;

import java.util.List;

public class ListaTransacoesDTO {

    private List<Transacao> transacaoList;

    public ListaTransacoesDTO() {
    }

    public ListaTransacoesDTO(List<Transacao> transacaoList){
        setTransacaoList(transacaoList);
    }

    public List<Transacao> getTransacaoList() {
        return transacaoList;
    }

    public void setTransacaoList(List<Transacao> transacaoList) {
        this.transacaoList = transacaoList;
    }

    public static ListaTransacoesDTO of(List<Transacao> transacaoList){
        return new ListaTransacoesDTO(transacaoList);
    }
}
