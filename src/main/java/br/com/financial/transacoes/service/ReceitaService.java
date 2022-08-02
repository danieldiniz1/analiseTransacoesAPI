package br.com.financial.transacoes.service;

import br.com.financial.transacoes.controller.form.ReceitaForm;
import br.com.financial.transacoes.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    public void adicionar(ReceitaForm receitaForm) {

    }
}
