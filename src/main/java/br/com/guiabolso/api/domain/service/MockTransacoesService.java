package br.com.guiabolso.api.domain.service;

import java.util.ArrayList;
import java.util.List;

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
	@Autowired MockTransacoes mockTransacoes;
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
			transacaoService.processar(t);
		}
		criaTransacaoDuplicada(transacoes);
		
		MockTransacoes.getMapTransacoes().put(transacoes.get(0).getChaveRequisicao(), transacoes);
		this.resultado.setTransacoes(transacoes);
	
		return this.resultado;
	}

	private void criaTransacaoDuplicada(List<Transacao> transacoes) {
		
		if(MesesTransacoesDuplicadas.getmapMeses().containsValue(transacoes.get(0).getMes())) {
			Transacao transacaoDuplicada = new Transacao();
			transacaoDuplicada.setDescricao(transacoes.get(0).getDescricao());
			transacaoDuplicada.setData(transacoes.get(0).getData());
			transacaoDuplicada.setValor(transacoes.get(0).getValor());
			transacaoDuplicada.setDuplicated(true);
		
			transacoes.add(transacaoDuplicada);
			
		}
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
