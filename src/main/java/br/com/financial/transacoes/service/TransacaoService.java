package br.com.financial.transacoes.service;

import br.com.financial.transacoes.controller.dto.ListaTransacoesDTO;
import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.dto.TransacaoDTO;
import br.com.financial.transacoes.controller.form.CadastroForm;
import br.com.financial.transacoes.controller.form.UpdateForm;

public interface TransacaoService {

    TransacaoCriadaDTO adicionarTransacao(CadastroForm cadastroForm);

    ListaTransacoesDTO getTodasTransacoes();

    TransacaoDTO buscarTransacaoPorId(Long id);

    void atualizarTransacao(UpdateForm updateForm, Long id);

    void deletarTransacao(Long id);

    TransacaoDTO buscarTransacaoPorDescricao(String descricao);
}
