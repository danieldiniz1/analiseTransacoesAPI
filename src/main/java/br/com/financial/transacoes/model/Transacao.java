package br.com.financial.transacoes.model;

import br.com.financial.transacoes.controller.form.CadastroForm;
import br.com.financial.transacoes.model.enums.Categoria;
import br.com.financial.transacoes.model.enums.Conta;
import br.com.financial.transacoes.model.enums.Tipo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "transacoes")
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Tipo tipo;
    @Column(name = "data_do_Lancamento")
    private LocalDate dataTransacao;
    private String descricao;
    private Categoria categoria;
    private Conta conta;
    private BigDecimal valorTransacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Transacao() {
    }

    public Transacao(Tipo tipo, LocalDate dataTransacao, String descricao, Categoria categoria, Conta conta, BigDecimal valorTransacao) {
        this.tipo = tipo;
        this.dataTransacao = dataTransacao;
        this.descricao = descricao;
        this.categoria = categoria;
        this.conta = conta;
        this.valorTransacao = valorTransacao;
    }
    public Transacao(CadastroForm cadastroForm, Tipo tipo) {
        this.tipo = tipo;
        this.dataTransacao = LocalDate.parse(cadastroForm.getDataLancamento());
//        this.dataTransacao = LocalDateTime.now();
        this.descricao = cadastroForm.getDescricao();
        validaCategoria(cadastroForm);
        this.conta = Conta.toEnumConta(Integer.parseInt(cadastroForm.getConta()));
        this.valorTransacao = BigDecimal.valueOf(Double.valueOf(cadastroForm.getValor()));
    }

    private void validaCategoria(CadastroForm cadastroForm) {
        if (cadastroForm.getCategoria() == null ||
                cadastroForm.getCategoria().isBlank() ||
                cadastroForm.getCategoria().isEmpty()){
            this.categoria = Categoria.toEnumCategoria(0);
        }else {
            this.categoria = Categoria.toEnumCategoria(Integer.parseInt(cadastroForm.getCategoria()));
        }
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

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
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

    public static Transacao of(CadastroForm cadastroForm, Tipo tipo){
        Transacao transacao = new Transacao(cadastroForm, tipo);
        return transacao;
    }

}
