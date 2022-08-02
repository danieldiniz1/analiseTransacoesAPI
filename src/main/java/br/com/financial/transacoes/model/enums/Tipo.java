package br.com.financial.transacoes.model.enums;

public enum Tipo {

    RECEITA(1,"Receitas"),
    DESPESA(2,"Despesas");

    private Integer id;
    private String despesa;

    Tipo(Integer id, String despesa) {
        this.id = id;
        this.despesa = despesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
    }
    public static Tipo toEnumTipo(Integer id){
        if (id == null){
            return null;
        }
        for (Tipo tipo : Tipo.values()) {
            if (tipo.getId().equals(id)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código de tipo inválido: " + id);
    }
}
