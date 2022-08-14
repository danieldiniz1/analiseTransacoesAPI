package br.com.financial.transacoes.repository;

import br.com.financial.transacoes.model.Transacao;
import br.com.financial.transacoes.model.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long> {

    List<Transacao> findAllByTipo(Tipo tipo);
    Transacao findByIdAndTipo(Long id, Tipo tipo);
    Transacao findByDescricaoAndTipo(String Descricao,Tipo tipo);
}
