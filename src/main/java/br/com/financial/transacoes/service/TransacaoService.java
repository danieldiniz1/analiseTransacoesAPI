package br.com.financial.transacoes.service;

import br.com.financial.transacoes.controller.dto.TransacaoCriadaDTO;
import br.com.financial.transacoes.controller.form.CadastroForm;

public interface TransacaoService {

    TransacaoCriadaDTO adicionar(CadastroForm cadastroForm);
}
