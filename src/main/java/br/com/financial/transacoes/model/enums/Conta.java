package br.com.financial.transacoes.model.enums;

public enum Conta {

    CORRENTE(1, "Conta Corrente"),
    POUPANCA(2, "Conta Poupança"),
    INVESTIMENTO(3,"Conta Investimento"),
    CARTAO_DE_CREDITO(4,"Cartão de Crédito");

    private Integer id;
    private String descricao;

    Conta(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Conta toEnumConta(Integer id){
        if (id == null){
            return null;
        }
        for (Conta conta : Conta.values()) {
            if (conta.getId().equals(id)){
               return conta;
            }
        }
        throw new IllegalArgumentException("Código de conta inválido: " + id);
    }
}
