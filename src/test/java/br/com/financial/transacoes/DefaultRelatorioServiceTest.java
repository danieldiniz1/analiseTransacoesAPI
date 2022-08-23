package br.com.financial.transacoes;

import br.com.financial.transacoes.controller.dto.relatoriodto.RelatorioDTO;
import br.com.financial.transacoes.model.enums.Categoria;
import br.com.financial.transacoes.repository.TransacaoRepository;
import br.com.financial.transacoes.service.impl.DefaultRelatorioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class DefaultRelatorioServiceTest {

    @InjectMocks
    private DefaultRelatorioService defaultRelatorioService;
    @Mock
    private TransacaoRepository transacaoRepository;

    private RelatorioDTO relatorioDTOExpected;

    @BeforeEach
    public void setup(){
        Map<Categoria,BigDecimal> saldoPorCategoria = new HashMap<>();
        relatorioDTOExpected = RelatorioDTO.of(BigDecimal.valueOf(000).setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(0000).setScale(2,RoundingMode.HALF_UP),
                BigDecimal.valueOf(000).setScale(2,RoundingMode.HALF_UP),
                generateMap(saldoPorCategoria));
    }

    @Test
    public void deveDevovlerUmRelatorioDTOcompletoSemLancarExceptionComDespesasDeOitocentosReceitasdeMilESaldodeDuzentosComCemParaCadaCategoria(){
        Integer ano = 2020;
        Integer mes = 9;
        RelatorioDTO relatorioDTOResult = Assertions.assertDoesNotThrow(() -> defaultRelatorioService.relatorioMensal(ano, mes));
        Assertions.assertEquals(relatorioDTOExpected.getSaldo(),relatorioDTOResult.getSaldo());
    }

    @Test
    public void deveDevolverUmaExceptionQuandoOParametroEnviadoEVazio(){
        Assertions.assertThrows(Exception.class, () -> defaultRelatorioService.relatorioMensal(Integer.parseInt(""),Integer.parseInt("")));
    }
    @Test
    public void deveDevolverUmaExceptionQuandoOParametroEnviadoNaoEUmInteiro(){
        Assertions.assertThrows(Exception.class, () -> defaultRelatorioService.relatorioMensal(Integer.parseInt("xyz"),Integer.parseInt("zye")));
    }

    private Map<Categoria, BigDecimal> generateMap(Map<Categoria, BigDecimal> saldoPorCategoria) {
        for (int i = 0; i <= 7; i++){
            Categoria categoria = Categoria.toEnumCategoria(i);
            saldoPorCategoria.put(categoria,BigDecimal.valueOf(200).setScale(2,RoundingMode.HALF_UP));
        }
        return saldoPorCategoria;
    }
}
