package br.com.financial.transacoes.service.impl;

import br.com.financial.transacoes.controller.dto.ListaTransacoesDTO;
import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.dto.TransacaoDTO;
import br.com.financial.transacoes.controller.form.CadastroForm;
import br.com.financial.transacoes.controller.form.UpdateForm;
import br.com.financial.transacoes.model.Transacao;
import br.com.financial.transacoes.model.enums.Tipo;
import br.com.financial.transacoes.repository.TransacaoRepository;
import br.com.financial.transacoes.service.TransacaoDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDespesaService implements TransacaoDespesaService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    private Tipo tipo = Tipo.toEnumTipo(2);

    @Override
    public TransacaoCriadaDTO adicionarTransacao(CadastroForm cadastroForm) {
        Transacao transacao = transacaoRepository.save(converterFormToModel(cadastroForm));
        return TransacaoCriadaDTO.of(transacao);
    }


    @Override
    public ListaTransacoesDTO getTodasTransacoes() {
        return null;
    }

    @Override
    public TransacaoDTO buscarTransacaoPorId(Long id) {
        return null;
    }

    @Override
    public void atualizarTransacao(UpdateForm updateForm, Long id) {

    }

    @Override
    public void deletarTransacao(Long id) {

    }

    private Transacao converterFormToModel(CadastroForm cadastroForm) {
        return Transacao.of(cadastroForm,tipo);
    }
}
