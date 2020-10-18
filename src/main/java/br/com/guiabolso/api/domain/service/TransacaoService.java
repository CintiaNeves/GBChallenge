package br.com.guiabolso.api.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.strategy.IStrategy;
import br.com.guiabolso.api.strategy.transacaoBuilder.GeraChaveUnicaRequisicao;
import br.com.guiabolso.api.strategy.transacaoBuilder.GeraChaveUnicaTransacao;
import br.com.guiabolso.api.strategy.transacaoBuilder.GeraDescricaoTransacao;
import br.com.guiabolso.api.strategy.transacaoBuilder.GeraDiaTransacao;
import br.com.guiabolso.api.strategy.transacaoBuilder.GeraValorTransacao;

@Service
public class TransacaoService {
	
	@Autowired GeraChaveUnicaRequisicao geraChaveUnicaRequisicao;
	@Autowired GeraChaveUnicaTransacao geraChaveUnicaTransacao;
	@Autowired GeraDiaTransacao geraDiaTransacao;
	@Autowired GeraDescricaoTransacao geraDescricaoTransacao;
	@Autowired GeraValorTransacao geraValorTransacao;
	@Autowired Resultado resultado;

	public Resultado processar(Transacao transacao) {
		
		List<IStrategy> listStrategy = getListStrategy();
		
		for(IStrategy strategy: listStrategy) {		
			this.resultado = strategy.processar(transacao);
			if(this.resultado.isErro()) break;
		}
		
		return this.resultado;
	}
	
	private List<IStrategy> getListStrategy(){
		
		List<IStrategy> listStrategy = new ArrayList<>();
		
		listStrategy.add(geraDiaTransacao);
		listStrategy.add(geraChaveUnicaRequisicao);
		listStrategy.add(geraChaveUnicaTransacao);
		listStrategy.add(geraDescricaoTransacao);
		listStrategy.add(geraValorTransacao);

		return listStrategy;
	}
}
