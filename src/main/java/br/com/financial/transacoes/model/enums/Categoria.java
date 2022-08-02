package br.com.financial.transacoes.model.enums;

public enum Categoria {

    OUTRAS(0,"Valor Default"),
    ALIMENTACAO(1, "Gastos com Alimentação como Restaurantes, bares, mercado"),
    SAUDE(2,"Gastos com Saude como farmacia, medico"),
    MORADIA(3,"Gatsos com Moradia como alugel, financiamento, juros"),
    TRANSPORTE(4,"Gastos com Trasnporte como onibus, combustivel, seguro"),
    EDUCACAO(5,"Gastos com Educação, como escola, faculdade, cursos "),
    LAZER(6,"Gastos com Lazer como festas, lanches e saidas"),
    IMPREVISTOS(7,"Gastos com Imprevistos como acidentes"),
    SALARIO(8,"Receita proveniente de Salarios e trabalho"),
    RENDIMENTOS(9,"Receita proveniente de rendimentos financeiros"),
    RECEBÍVES(10,"Receita proveniente de outros recebíveis");

    private Integer codigo;
    private String descricao;

    Categoria(Integer id, String descricao) {
        this.codigo = id;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Categoria toEnumCategoria(Integer codigo){
        if (codigo == null){
            return null;
        }
        for (Categoria categoria : Categoria.values()) {
            if (codigo.equals(categoria.getCodigo())){
                return categoria;
            }
        }

        throw new IllegalArgumentException("código de categoria inválid: " + codigo);
    }
}
