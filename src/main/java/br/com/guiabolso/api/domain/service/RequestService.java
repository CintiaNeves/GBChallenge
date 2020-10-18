package br.com.guiabolso.api.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.TransacaoInputData;
import br.com.guiabolso.api.strategy.IStrategy;
import br.com.guiabolso.api.strategy.inputValidation.ValidaAnoTransacao;
import br.com.guiabolso.api.strategy.inputValidation.ValidaMesTransacao;
import br.com.guiabolso.api.strategy.inputValidation.ValidaUsuarioId;

@Service
public class RequestService {

	@Autowired ValidaUsuarioId validaUsuarioId;
	@Autowired ValidaAnoTransacao validaAnoTransacao;
	@Autowired ValidaMesTransacao validaMesTransacao;
	@Autowired Resultado resultado;

	
	public Resultado validar(TransacaoInputData transacaoInputData) {
	
		List<IStrategy> listStrategy = getListStrategy();
		
		for(IStrategy strategy: listStrategy) {		
			this.resultado = strategy.processar(transacaoInputData);
			if(resultado.isErro()) break;
		}
		
		return this.resultado;
	}
	
	private List<IStrategy> getListStrategy(){
		
		List<IStrategy> listStrategy = new ArrayList<>();
		
		listStrategy.add(validaUsuarioId);
		listStrategy.add(validaAnoTransacao);
		listStrategy.add(validaMesTransacao);
		
		return listStrategy;
	}

}
