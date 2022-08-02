package br.com.financial.transacoes.model;

import br.com.financial.transacoes.model.enums.Categoria;
import br.com.financial.transacoes.model.enums.Conta;
import br.com.financial.transacoes.model.enums.Tipo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transacoes")
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Tipo tipo;
    @Column(name = "data_do_Lancamento")
    private LocalDateTime dataTransacao;
    private String descricao;
    private Categoria categoria;
    private Conta conta;
    private BigDecimal valorTransacao;

    public Transacao() {
    }

    public Transacao(Tipo tipo, LocalDateTime dataTransacao, String descricao, Categoria categoria, Conta conta, BigDecimal valorTransacao) {
        this.tipo = tipo;
        this.dataTransacao = dataTransacao;
        this.descricao = descricao;
        this.categoria = categoria;
        this.conta = conta;
        this.valorTransacao = valorTransacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }
}
