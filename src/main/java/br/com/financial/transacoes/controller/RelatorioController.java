package br.com.financial.transacoes.controller;

import br.com.financial.transacoes.controller.dto.relatoriodto.RelatorioDTO;
import br.com.financial.transacoes.service.RelatorioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {


    @Autowired
    private RelatorioService relatorioService;
    private static final Logger LOGGER = LogManager.getLogger(RelatorioController.class);

    @GetMapping("/{ano}/{mes}")
    public ResponseEntity<RelatorioDTO> geraRelatorioMensal(@PathVariable Integer ano, @PathVariable Integer mes){
        LOGGER.info("mês: " + mes.toString() + ", ano: " + ano.toString() + ".");
        return validate(ano, mes);
    }

    private ResponseEntity<RelatorioDTO> validate(Integer ano, Integer mes) {
        RelatorioDTO relatorioDTO = null;
        try {
            relatorioDTO = relatorioService.relatorioMensal(ano,mes);
        } catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(relatorioDTO);
    }
}
