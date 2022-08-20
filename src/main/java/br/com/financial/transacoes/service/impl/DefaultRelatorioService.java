package br.com.financial.transacoes.service.impl;

import br.com.financial.transacoes.controller.dto.relatoriodto.RelatorioDTO;
import br.com.financial.transacoes.model.Transacao;
import br.com.financial.transacoes.model.enums.Categoria;
import br.com.financial.transacoes.model.enums.Tipo;
import br.com.financial.transacoes.repository.TransacaoRepository;
import br.com.financial.transacoes.service.RelatorioService;
import br.com.financial.transacoes.service.TransacaoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;

@Service
public class DefaultRelatorioService implements RelatorioService {
    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private TransacaoRepository transacaoRepository;
    private final Tipo tipoReceita = Tipo.toEnumTipo(1);
    private final Tipo tipoDespesa = Tipo.toEnumTipo(2);


    @Override
    public RelatorioDTO relatorioMensal(Integer ano, Integer mes) {
        LocalDate dataInicial = LocalDate.of(ano, mes, 1);
        LocalDate dataFinal = dataInicial.plusMonths(1L).minusDays(1L);
        BigDecimal totalDespesas = somaTotalDeLancamentos(transacaoRepository.findByDataTransacaoBetweenAndTipo(dataInicial,dataFinal,tipoDespesa));
        BigDecimal totalReceita = somaTotalDeLancamentos(transacaoRepository.findByDataTransacaoBetweenAndTipo(dataInicial,dataFinal,tipoReceita));
        Map<Categoria,BigDecimal> saldoPorCategoria = new HashMap<>();
        somarTotalPorCategoria(transacaoRepository.findByDataTransacaoBetweenAndTipo(dataInicial,dataFinal,tipoDespesa), saldoPorCategoria);

        return RelatorioDTO.of(totalDespesas.setScale(2, RoundingMode.HALF_UP),
                totalReceita.setScale(2,RoundingMode.HALF_UP)
                ,totalReceita.subtract(totalDespesas).setScale(2,RoundingMode.HALF_UP)
                ,saldoPorCategoria);
    }

    private void somarTotalPorCategoria(List<Transacao> listaComTransacoes, Map<Categoria,BigDecimal> saldoPorCategoria) {
        for (int i = 0; i<=7; i++){
            //até 7 pq categorias de despesas são de 0 a 7
            final Categoria categoria = Categoria.toEnumCategoria(i);
            saldoPorCategoria.put(categoria,
                    BigDecimal.valueOf(listaComTransacoes.stream()
                            .filter(transacao -> transacao.getCategoria().equals(categoria))
                            .mapToDouble(t -> t.getValorTransacao().doubleValue()).sum()).setScale(2,RoundingMode.HALF_UP));
        }

    }

    private BigDecimal somaTotalDeLancamentos(List<Transacao> listaComTransacoes) {
        return BigDecimal.valueOf(listaComTransacoes.stream().mapToDouble(transacao -> transacao.getValorTransacao().doubleValue()).sum());
    }
}
