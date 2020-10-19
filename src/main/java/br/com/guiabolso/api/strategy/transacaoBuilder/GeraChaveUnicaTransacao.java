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
		int ano = transacao.getAno();
		int mes = transacao.getMes();
		Long dia = transacao.getData();
		int valor = transacao.getValor();
		String chaveUnica = String.valueOf(valor).concat(id.toString().concat(String.valueOf(mes))
				.concat(String.valueOf(ano)).concat(dia.toString()).concat(String.valueOf(valor)));
		transacao.setChaveUnica(chaveUnica);
		resultado.setErro(false);
		
		return resultado;
	}

}
