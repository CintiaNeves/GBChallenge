package br.com.guiabolso.api.strategy.mockTransacoesBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.MockTransacoes;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.strategy.IStrategy;
import br.com.guiabolso.api.strategy.transacaoBuilder.GeraChaveUnicaRequisicao;

@Component
public class ValidaExistenciaRequisicao implements IStrategy{

	@Autowired GeraChaveUnicaRequisicao geraChaveUnicaRequisicao;
	
	@Override
	public Resultado processar(IEntidadeDominio entidade) {
		
		geraChaveUnicaRequisicao.processar(entidade);
		Transacao transacao = (Transacao) entidade;
		
		resultado.setTransacoes(MockTransacoes.getMapTransacoes().get(transacao.getChaveRequisicao()));
		resultado.setErro(false);
		
		return resultado;
	}

}
