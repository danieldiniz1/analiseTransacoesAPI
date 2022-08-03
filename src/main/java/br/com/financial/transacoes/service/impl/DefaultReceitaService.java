package br.com.financial.transacoes.service.impl;

import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.form.CadastroForm;
import br.com.financial.transacoes.model.Transacao;
import br.com.financial.transacoes.model.enums.Tipo;
import br.com.financial.transacoes.repository.TransacaoRepository;
import br.com.financial.transacoes.service.TransacaoReceitaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultReceitaService implements TransacaoReceitaService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    private static final Logger LOGGER = LogManager.getLogger(DefaultReceitaService.class);
    private final Tipo tipo = Tipo.toEnumTipo(1);
    public TransacaoCriadaDTO adicionarTransacao(CadastroForm receitaForm) {
        Transacao save = transacaoRepository.save(convertFormToModel(receitaForm));
        Optional<Transacao> transacaoSalva = transacaoRepository.findById(save.getId());
        Transacao transacao = transacaoSalva.get();
        return convertTransacaoToDTO(transacao);

    }

    private TransacaoCriadaDTO convertTransacaoToDTO(Transacao transacao) {
        return new TransacaoCriadaDTO(transacao.getId().toString(),
                transacao.getCategoria(),
                transacao.getTipo(),
                transacao.getConta());

    }

    private Transacao convertFormToModel(CadastroForm receitaForm) {
        return Transacao.of(receitaForm, tipo);
    }

    public TransacaoRepository getTransacaoRepository() {
        return transacaoRepository;
    }

    public void setTransacaoRepository(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }
}
