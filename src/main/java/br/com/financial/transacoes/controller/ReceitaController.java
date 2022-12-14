package br.com.financial.transacoes.controller;

import br.com.financial.transacoes.controller.dto.ListaTransacoesDTO;
import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.dto.TransacaoDTO;
import br.com.financial.transacoes.controller.form.CadastroReceitaForm;
import br.com.financial.transacoes.controller.form.UpdateForm;
import br.com.financial.transacoes.model.Transacao;
import br.com.financial.transacoes.service.TransacaoReceitaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity updateReceita(@PathVariable Long id, @RequestBody UpdateForm updateForm){
        transacaoReceitaService.atualizarTransacao(updateForm, id);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReceita(@PathVariable Long id){
        transacaoReceitaService.deletarTransacao(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("buscar-descricao")
    public ResponseEntity<TransacaoDTO> buscarReceitaPorDescricao(@RequestParam String descricao){
        LOGGER.info("iniciado busca de receita com descri????o: " + descricao);
        transacaoReceitaService.buscarTransacaoPorDescricao(descricao);
        return ResponseEntity.ok().body(transacaoReceitaService.buscarTransacaoPorDescricao(descricao));
    }

    @GetMapping("/{ano}/{mes}")
    public ResponseEntity<ListaTransacoesDTO> buscarReceitaPorMesEAno(@PathVariable String ano, @PathVariable String mes){
        LOGGER.info("Iniciando busca por receita de ano: " + ano + " e m??s: " + mes);
        return ResponseEntity.ok().body(transacaoReceitaService.buscarTransacaoPorMesEAno(Integer.parseInt(ano),Integer.parseInt(mes)));
    }
}
