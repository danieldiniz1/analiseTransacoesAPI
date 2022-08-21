package br.com.financial.transacoes;

import br.com.financial.transacoes.controller.RelatorioController;
import br.com.financial.transacoes.controller.dto.relatoriodto.RelatorioDTO;
import br.com.financial.transacoes.model.enums.Categoria;
import br.com.financial.transacoes.service.RelatorioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RelatorioControllerTest {

    @InjectMocks
    private RelatorioController relatorioController;

    @Mock
    private RelatorioService relatorioService;

    private RelatorioDTO relatorioDTOCompleted;
    private ResponseEntity<RelatorioDTO> responseCompleted;
    private Map<Categoria,BigDecimal> saldoPorCategoria = new HashMap<>();

    @BeforeEach
    void setup(){
        populateMap(saldoPorCategoria);
        relatorioDTOCompleted = RelatorioDTO.of(BigDecimal.valueOf(800),BigDecimal.valueOf(1000),BigDecimal.valueOf(200),saldoPorCategoria);
        responseCompleted = ResponseEntity.status(200).body(relatorioDTOCompleted);
    }

    @Test
    void deveDevolverUmRelatorioDTOComSOmaDeTodosOsLancamentosDoPeriodo(){
        Integer ano = 2020;
        Integer mes = 9;
        assertDoesNotThrow(() -> relatorioController.geraRelatorioMensal(ano, mes));
//        when(relatorioController.geraRelatorioMensal(ano,mes)).thenReturn(responseCompleted);

    }

    private void populateMap(Map<Categoria, BigDecimal> saldoPorCategoria) {
        for (int i = 0; i <= 7; i++){
            Categoria categoria = Categoria.toEnumCategoria(i);
            saldoPorCategoria.put(categoria,BigDecimal.valueOf(100));
        }
    }
}
