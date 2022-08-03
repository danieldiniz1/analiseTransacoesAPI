package br.com.financial.transacoes.controller;

import br.com.financial.transacoes.controller.dto.ListaTransacoesDTO;
import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.dto.TransacaoDTO;
import br.com.financial.transacoes.controller.form.CadastroReceitaForm;
import br.com.financial.transacoes.service.TransacaoReceitaService;
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
    private TransacaoReceitaService transacaoReceitaService;

    private static final Logger LOGGER = LogManager.getLogger(ReceitaController.class);

    @PostMapping("/adicionar-receita")
    @ResponseBody
    public ResponseEntity<TransacaoCriadaDTO> cadastroReceita(@RequestBody @Valid CadastroReceitaForm receitaForm){
        TransacaoCriadaDTO transacaoCriadaDTO = transacaoReceitaService.adicionarTransacao(receitaForm);

        return ResponseEntity.status(201).body(transacaoCriadaDTO);
    }

    @GetMapping
    public ResponseEntity<ListaTransacoesDTO> buscaTodasReceitas(){
        return ResponseEntity.status(200).body(transacaoReceitaService.getTodasTransacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoDTO> buscarReceitaPorId(@PathVariable Long id){
        return ResponseEntity.status(200).body(transacaoReceitaService.buscarTransacaoPorId(id));
    }
}
