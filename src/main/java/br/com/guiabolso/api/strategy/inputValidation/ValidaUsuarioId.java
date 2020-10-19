package br.com.guiabolso.api.strategy.inputValidation;

import static br.com.guiabolso.api.domain.enums.UsuarioId.ID_MAXIMO;
import static br.com.guiabolso.api.domain.enums.UsuarioId.ID_MINIMO;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.TransacaoInputData;
import br.com.guiabolso.api.domain.exception.UserNotFoundException;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class ValidaUsuarioId implements IStrategy{

	@Override
	public Resultado processar(IEntidadeDominio entidade) {
	
		TransacaoInputData data = (TransacaoInputData) entidade;
		
		if(ID_MINIMO.valorId > data.getUsuarioId() || ID_MAXIMO.valorId < data.getUsuarioId()) {
			resultado.setErro(true);
			resultado.setMensagem("Usuario não encontrado. O ID do usuário deve estar entre 1.000 e 100.000.000.");
			throw new UserNotFoundException(resultado.getMensagem());
		}else {
			resultado.setErro(false);
		}
		
		return resultado;
	}

}
