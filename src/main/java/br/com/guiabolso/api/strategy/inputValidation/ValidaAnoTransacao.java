package br.com.guiabolso.api.strategy.inputValidation;

import static br.com.guiabolso.api.domain.enums.Ano.ANO_MAXIMO;
import static br.com.guiabolso.api.domain.enums.Ano.ANO_MINIMO;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.TransacaoInputData;
import br.com.guiabolso.api.domain.enums.Ano;
import br.com.guiabolso.api.domain.exception.OutOfRangeYearException;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class ValidaAnoTransacao implements IStrategy{

	@Override
	public Resultado processar(IEntidadeDominio entidade) {
		
		TransacaoInputData data = (TransacaoInputData) entidade;
		
		if(ANO_MINIMO.valorAno > data.getAno() || ANO_MAXIMO.valorAno < data.getAno()) {
			resultado.setErro(true);
			resultado.setMensagem("Ano inválido, ano deve estar entre " + Ano.ANO_MINIMO.valorAno + " e " + Ano.ANO_MAXIMO.valorAno + ".");
			throw new OutOfRangeYearException(resultado.getMensagem());
		}else {
			resultado.setErro(false);
			resultado.setMensagem("O Ano é válido");
		}
		
		return resultado;
	}

}
