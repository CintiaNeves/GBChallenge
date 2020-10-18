package br.com.guiabolso.api.strategy.transacaoBuilder;

import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.domain.entity.TransacoesExcutadas;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class ValidaExistenciaTransacao implements IStrategy{

	@Override
	public Resultado processar(IEntidadeDominio entidade) {
		
		Transacao transacao = (Transacao) entidade;
		transacao.setDuplicated(false);
		
		for (Map.Entry<String,Transacao> pair : TransacoesExcutadas.getTransacoes().entrySet()) {
		  
		    if(pair.getValue().equals(transacao))
		    	transacao.setDuplicated(true);
		}
	
		TransacoesExcutadas.getTransacoes().put(transacao.getChaveUnica(), transacao);
		resultado.setErro(false);
		
		return resultado;
	}
	
}
