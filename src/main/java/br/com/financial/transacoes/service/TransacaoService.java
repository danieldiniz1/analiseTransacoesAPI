package br.com.financial.transacoes.service;

import br.com.financial.transacoes.controller.dto.ListaTransacoesDTO;
import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.dto.TransacaoDTO;
import br.com.financial.transacoes.controller.form.CadastroForm;

import java.util.List;

public interface TransacaoService {

    TransacaoCriadaDTO adicionarTransacao(CadastroForm cadastroForm);

    ListaTransacoesDTO getTodasTransacoes();

    TransacaoDTO buscarTransacaoPorId(Long id);
}
