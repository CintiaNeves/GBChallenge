package br.com.guiabolso.api.strategy.transacaoBuilder;

import java.util.Random;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class GeraValorTransacao implements IStrategy{

	@Override
	public Resultado processar(IEntidadeDominio entidade) {
		
		Transacao transacao = (Transacao) entidade;
		
		Random gerador = new Random();
		
		Long  valor = new Long(Math.abs(gerador.nextInt()) % 9999999);
		transacao.setValor(valor.intValue());
		
		return resultado;
	}

}
