package br.com.financial.transacoes.service.impl;

import br.com.financial.transacoes.controller.dto.ListaTransacoesDTO;
import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.dto.TransacaoDTO;
import br.com.financial.transacoes.controller.form.CadastroForm;
import br.com.financial.transacoes.controller.form.UpdateForm;
import br.com.financial.transacoes.exception.TransactionNotFoundExcpetion;
import br.com.financial.transacoes.model.Transacao;
import br.com.financial.transacoes.model.enums.Tipo;
import br.com.financial.transacoes.repository.TransacaoRepository;
import br.com.financial.transacoes.service.TransacaoDespesaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DefaultDespesaService implements TransacaoDespesaService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    private Tipo tipo = Tipo.toEnumTipo(2);

    private static final Logger LOGGER = LogManager.getLogger(DefaultDespesaService.class);

    @Override
    public TransacaoCriadaDTO adicionarTransacao(CadastroForm cadastroForm) {
        Transacao transacao = transacaoRepository.save(converterFormToModel(cadastroForm));
        return TransacaoCriadaDTO.of(transacao);
    }


    @Override
    public ListaTransacoesDTO getTodasTransacoes() {
        return new ListaTransacoesDTO(transacaoRepository.findAllByTipo(tipo));
    }

    @Override
    public TransacaoDTO buscarTransacaoPorId(Long id) {
        TransacaoDTO transacaoDTO = null;
        try {
            transacaoDTO = new TransacaoDTO(transacaoRepository.findByIdAndTipo(id, tipo));
        } catch (TransactionNotFoundExcpetion transactionNotFoundExcpetion){
            LOGGER.info("Transação com id: " + id.toString() + " não foi encontrada");
        }
        return transacaoDTO;
    }

    @Override
    public void atualizarTransacao(UpdateForm updateForm, Long id) {
        Transacao transacaoASerAtualizada = transacaoRepository.findByIdAndTipo(id, tipo);
        atualizaTransacao(updateForm, transacaoASerAtualizada);
        transacaoRepository.save(transacaoASerAtualizada);
    }

    @Override
    public void deletarTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }

    @Override
    public TransacaoDTO buscarTransacaoPorDescricao(String descricao) {
        Transacao transacao = null;
        try {
            transacao = transacaoRepository.findByDescricaoAndTipo(descricao,tipo);
        } catch (TransactionNotFoundExcpetion transactionNotFoundExcpetion){
            LOGGER.info("Transação com descrição: " + descricao + " não foi encontrada");
        }
        return new TransacaoDTO(transacao);
    }

    private Transacao converterFormToModel(CadastroForm cadastroForm) {
        return Transacao.of(cadastroForm,tipo);
    }

    private void atualizaTransacao(UpdateForm updateForm, Transacao transacaoASerAtualizada) {
        transacaoASerAtualizada.setDescricao(updateForm.getDescricao());
        transacaoASerAtualizada.setValorTransacao(BigDecimal.valueOf(Double.valueOf(updateForm.getValor())));
    }
}
