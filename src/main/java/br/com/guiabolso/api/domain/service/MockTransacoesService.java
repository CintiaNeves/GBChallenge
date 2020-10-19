package br.com.guiabolso.api.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guiabolso.api.domain.entity.MockTransacoes;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.domain.util.MesesTransacoesDuplicadas;
import br.com.guiabolso.api.strategy.IStrategy;
import br.com.guiabolso.api.strategy.mockTransacoesBuilder.CriaListaTransacoes;
import br.com.guiabolso.api.strategy.mockTransacoesBuilder.ValidaExistenciaRequisicao;

@Service
public class MockTransacoesService {

	@Autowired CriaListaTransacoes criaListaTransacoes;
	@Autowired Resultado resultado;
	@Autowired TransacaoService transacaoService;
	@Autowired ValidaExistenciaRequisicao validaExistenciaRequisicao;

	public List<Transacao> listar(String chaveRequisicao) {
		return MockTransacoes.getMapTransacoes().get(chaveRequisicao);
	}

	public Resultado criar(Transacao transacao) {

		List<IStrategy> listStrategy = getListStrategy();

		for (IStrategy strategy : listStrategy) {
			this.resultado = strategy.processar(transacao);
			if (this.resultado.isErro())
				break;
		}
			
		List<Transacao> transacoes = resultado.getTransacoes();
		
		for (Transacao t : transacoes) {
			transacaoService.processaRegrasCriacao(t);
		}
		
		if(isMonthToDuplicateTransacao(transacoes.get(0)))
			criaTransacaoDuplicada(transacoes);
		
		MockTransacoes.getMapTransacoes().put(transacoes.get(0).getChaveRequisicao(), transacoes);
		this.resultado.setTransacoes(transacoes);
	
		return this.resultado;
	}

	private void criaTransacaoDuplicada(List<Transacao> transacoes) {
		
			Transacao transacaoDuplicada = new Transacao();
			Random gerador = new Random();
			int i = Math.abs(gerador.nextInt()) % 3;
			
			transacaoDuplicada.setDescricao(transacoes.get(i).getDescricao());
			transacaoDuplicada.setData(transacoes.get(i).getData());
			transacaoDuplicada.setValor(transacoes.get(i).getValor());
			transacaoDuplicada.setDuplicated(true);
		
			transacoes.add(transacaoDuplicada);
	}

	private boolean isMonthToDuplicateTransacao(Transacao transacao) {
		return MesesTransacoesDuplicadas.getmapMeses().containsValue(transacao.getMes());
	}
	
	public Resultado buscar(Transacao transacao) {
		return validaExistenciaRequisicao.processar(transacao);
	}

	private List<IStrategy> getListStrategy() {

		List<IStrategy> listStrategy = new ArrayList<>();
		listStrategy.add(criaListaTransacoes);
		return listStrategy;
	}
}
