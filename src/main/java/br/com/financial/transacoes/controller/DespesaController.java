package br.com.financial.transacoes.controller;

import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.form.CadastroDespesaForm;
import br.com.financial.transacoes.service.TransacaoDespesaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    private static final Logger LOGGER = LogManager.getLogger(DespesaController.class);

    @Autowired
    private TransacaoDespesaService transacaoDespesaService;

    @PostMapping("/adicionar-despesa")
    public ResponseEntity cadastroDespesa(@RequestBody CadastroDespesaForm cadastroDespesaForm){
        TransacaoCriadaDTO transacaoCriadaDTO = transacaoDespesaService.adicionarTransacao(cadastroDespesaForm);
        return ResponseEntity.status(201).body(transacaoCriadaDTO);
    }
}
