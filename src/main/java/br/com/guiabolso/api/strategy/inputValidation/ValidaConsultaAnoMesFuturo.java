package br.com.guiabolso.api.strategy.inputValidation;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.MockTransacoes;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.TransacaoInputData;
import br.com.guiabolso.api.domain.exception.DateFutureRequestException;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class ValidaConsultaAnoMesFuturo implements IStrategy{

	@Override
	public Resultado processar(IEntidadeDominio entidade) {
		
		TransacaoInputData data = (TransacaoInputData) entidade;
		
		int mesAtual = MockTransacoes.getDataDeHoje().getMonthValue();
		int anoAtual = MockTransacoes.getDataDeHoje().getYear();
		
		if(data.getAno() == anoAtual && data.getMes() > mesAtual) {
			resultado.setErro(true);
			resultado.setMensagem("Request cannot contain a future date.");
			throw new DateFutureRequestException(resultado.getMensagem());
		}else {
			resultado.setErro(false);
		}
		return resultado;
	}

}
