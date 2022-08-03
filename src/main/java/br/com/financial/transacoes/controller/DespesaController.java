package br.com.financial.transacoes.controller;

import br.com.financial.transacoes.controller.dto.ListaTransacoesDTO;
import br.com.financial.transacoes.controller.dto.TransacaoDTO;
import br.com.financial.transacoes.controller.form.CadastroDespesaForm;
import br.com.financial.transacoes.service.TransacaoDespesaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    private static final Logger LOGGER = LogManager.getLogger(DespesaController.class);

    @Autowired
    private TransacaoDespesaService transacaoDespesaService;

    @PostMapping("/adicionar-despesa")
    public ResponseEntity cadastroDespesa(@RequestBody CadastroDespesaForm cadastroDespesaForm){
        LOGGER.info("foi criado uma transação do tipo DESPESA");
        return ResponseEntity.status(201).body(transacaoDespesaService.adicionarTransacao(cadastroDespesaForm));
    }

    @GetMapping
    public ResponseEntity<ListaTransacoesDTO> buscarTodasDespesas(){
        return ResponseEntity.ok(transacaoDespesaService.getTodasTransacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoDTO> buscarDespesaporId(@PathVariable Long id){
        return ResponseEntity.ok(transacaoDespesaService.buscarTransacaoPorId(id));
    }



}
