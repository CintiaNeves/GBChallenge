package br.com.guiabolso.api.strategy.transacaoBuilder;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class GeraChaveUnicaTransacao implements IStrategy{

	@Override
	public Resultado processar(IEntidadeDominio entidade) {
	
		Transacao transacao = (Transacao) entidade;
		
		Long id = transacao.getUsuario().getId();
		Long ano = transacao.getAno();
		Long mes = transacao.getMes();
		
		String chaveUnica = id.toString().concat(mes.toString()).concat(ano.toString());
		transacao.setChaveUnica(chaveUnica);
		resultado.setErro(false);
		
		return resultado;
	}

}