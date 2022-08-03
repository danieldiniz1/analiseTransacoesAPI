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
import br.com.financial.transacoes.service.TransacaoReceitaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class DefaultReceitaService implements TransacaoReceitaService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    private static final Logger LOGGER = LogManager.getLogger(DefaultReceitaService.class);
    private final Tipo tipo = Tipo.toEnumTipo(1);
    public TransacaoCriadaDTO adicionarTransacao(CadastroForm receitaForm) {
        Transacao save = transacaoRepository.save(convertCadastroFormToModel(receitaForm));
//        Optional<Transacao> transacaoSalva = transacaoRepository.findById(save.getId());
//        Transacao transacao = transacaoSalva.get();
        return convertTransacaoToDTO(transacaoRepository.findById(save.getId()).get());
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
        Transacao transacao = transacaoRepository.findById(id).get();
        atualizaTransacao(transacao,updateForm);
        transacaoRepository.save(transacao);
    }

    @Override
    public void deletarTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }

    private void atualizaTransacao(Transacao transacao, UpdateForm updateForm) {
        LOGGER.info("descrição antiga " + transacao.getDescricao());
        LOGGER.info("descrição nova " + updateForm.getDescricao());
        transacao.setDescricao(updateForm.getDescricao());

        LOGGER.info("valor antigo " + transacao.getValorTransacao().toString());
        LOGGER.info("valor nova " + updateForm.getValor());
        transacao.setValorTransacao(BigDecimal.valueOf(Double.valueOf(updateForm.getValor())));
    }

    private TransacaoCriadaDTO convertTransacaoToDTO(Transacao transacao) {
        return new TransacaoCriadaDTO(transacao.getId().toString(),
                transacao.getCategoria(),
                transacao.getTipo(),
                transacao.getConta());

    }

    private Transacao convertCadastroFormToModel(CadastroForm receitaForm) {
        return Transacao.of(receitaForm, tipo);
    }

    public TransacaoRepository getTransacaoRepository() {
        return transacaoRepository;
    }

    public void setTransacaoRepository(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }
}
