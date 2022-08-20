package br.com.financial.transacoes.controller.dto.relatoriodto;

import br.com.financial.transacoes.model.enums.Categoria;

import java.math.BigDecimal;
import java.util.Map;

public class RelatorioDTO {

    private BigDecimal totalDespesas;
    private BigDecimal totalReceitas;
    private BigDecimal saldo;
    private Map<Categoria,BigDecimal> saldoPorCategoria;

    public RelatorioDTO() {
    }

    public RelatorioDTO(BigDecimal totalDespesas, BigDecimal totalReceitas, BigDecimal saldo, Map<Categoria, BigDecimal> saldoPorCategoria) {
        this.totalDespesas = totalDespesas;
        this.totalReceitas = totalReceitas;
        this.saldo = saldo;
        this.saldoPorCategoria = saldoPorCategoria;
    }

    public BigDecimal getTotalDespesas() {
        return totalDespesas;
    }

    public void setTotalDespesas(BigDecimal totalDespesas) {
        this.totalDespesas = totalDespesas;
    }

    public BigDecimal getTotalReceitas() {
        return totalReceitas;
    }

    public void setTotalReceitas(BigDecimal totalReceitas) {
        this.totalReceitas = totalReceitas;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Map<Categoria, BigDecimal> getSaldoPorCategoria() {
        return saldoPorCategoria;
    }

    public void setSaldoPorCategoria(Map<Categoria, BigDecimal> saldoPorCategoria) {
        this.saldoPorCategoria = saldoPorCategoria;
    }

    public static RelatorioDTO of(BigDecimal totalDespesas,
                                  BigDecimal totalReceitas,
                                  BigDecimal saldo,
                                  Map<Categoria,BigDecimal> saldoPorCategoria){
        return new RelatorioDTO(totalDespesas,totalReceitas,saldo,saldoPorCategoria);
    }
}
