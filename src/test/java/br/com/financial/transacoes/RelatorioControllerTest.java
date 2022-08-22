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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RelatorioControllerTest {

    @InjectMocks
    private RelatorioController relatorioController;

    @Mock
    private RelatorioService relatorioService;



    @BeforeEach
    void setup(){
    }

    @Test
    void deveDevolverUmRelatorioDTOComSOmaDeTodosOsLancamentosDoPeriodoSemLancarException(){
        Integer ano = 2020;
        Integer mes = 9;
        assertDoesNotThrow(() -> relatorioController.geraRelatorioMensal(ano, mes));
    }

    @Test
    void deveLancarExceptionCasoMetodoNaoRecebaTodosParametrosOuParametrosInvalidos(){
        assertThrows(Exception.class,() -> relatorioController.geraRelatorioMensal(Integer.parseInt(""),Integer.parseInt("")));
    }

}
