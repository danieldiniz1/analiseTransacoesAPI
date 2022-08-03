package br.com.financial.transacoes.controller;

import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.form.ReceitaForm;
import br.com.financial.transacoes.service.TransacaoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private TransacaoService transacaoService;

    private static final Logger LOGGER = LogManager.getLogger(ReceitaController.class);

    @PostMapping("/adicionar-receita")
    @ResponseBody
    public ResponseEntity<TransacaoCriadaDTO> cadastroReceita(@RequestBody @Valid ReceitaForm receitaForm){
        TransacaoCriadaDTO transacaoCriadaDTO = transacaoService.adicionar(receitaForm);

        return ResponseEntity.status(201).body(transacaoCriadaDTO);
    }
}
