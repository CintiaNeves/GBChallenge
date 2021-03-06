package br.com.guiabolso.api.strategy.inputValidation;

import static br.com.guiabolso.api.domain.enums.Mes.MES_MAXIMO;
import static br.com.guiabolso.api.domain.enums.Mes.MES_MINIMO;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.TransacaoInputData;
import br.com.guiabolso.api.domain.enums.Mes;
import br.com.guiabolso.api.domain.exception.OutOfRangeMonthException;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class ValidaMesTransacao implements IStrategy{

	@Override
	public Resultado processar(IEntidadeDominio entidade) {
		
		TransacaoInputData data = (TransacaoInputData) entidade;
		
		if(MES_MINIMO.valorMes > data.getMes() || MES_MAXIMO.valorMes < data.getMes()) {
			resultado.setErro(true);
			resultado.setMensagem("Invalid month, month must be between " + Mes.MES_MINIMO.valorMes + " and " + Mes.MES_MAXIMO.valorMes + ".");
			throw new OutOfRangeMonthException(resultado.getMensagem());
		}else {
			resultado.setErro(false);
			
		}
		
		return resultado;
	}

}
