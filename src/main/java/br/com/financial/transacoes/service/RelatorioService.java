package br.com.financial.transacoes.service;

import br.com.financial.transacoes.controller.dto.relatoriodto.RelatorioDTO;

public interface RelatorioService {

    RelatorioDTO relatorioMensal(Integer ano, Integer mes);
}
