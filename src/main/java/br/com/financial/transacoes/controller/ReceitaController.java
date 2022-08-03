package br.com.financial.transacoes.controller;

import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.form.ReceitaForm;
import br.com.financial.transacoes.model.enums.Categoria;
import br.com.financial.transacoes.model.enums.Conta;
import br.com.financial.transacoes.service.DefaultReceitaService;
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
    private DefaultReceitaService receitaService;

    private static final Logger LOGGER = LogManager.getLogger(ReceitaController.class);

    @PostMapping("/adicionar-receita")
    @ResponseBody
    public ResponseEntity<TransacaoCriadaDTO> cadastroReceita(@RequestBody @Valid ReceitaForm receitaForm){
        LOGGER.info("Valor R$ " + receitaForm.getValor());
        LOGGER.info("Descrição: " + receitaForm.getDescricao());
        LOGGER.info("Data de Lançamento: " + receitaForm.getDataLancamento());
        LOGGER.info("Categoria: " + Categoria.toEnumCategoria(Integer.parseInt(receitaForm.getCategoria())));
        LOGGER.info("Conta " + Conta.toEnumConta(Integer.parseInt(receitaForm.getConta())));

        TransacaoCriadaDTO transacaoCriadaDTO = receitaService.adicionar(receitaForm);

        return ResponseEntity.status(202).body(transacaoCriadaDTO);
    }
}
