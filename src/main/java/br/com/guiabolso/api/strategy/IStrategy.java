package br.com.guiabolso.api.strategy;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;

public interface IStrategy {
	
	Resultado resultado = new Resultado();
	
	public Resultado processar(IEntidadeDominio entidade);
}
