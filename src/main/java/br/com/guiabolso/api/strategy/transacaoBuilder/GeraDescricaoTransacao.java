package br.com.guiabolso.api.strategy.transacaoBuilder;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.domain.util.Vogais;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class GeraDescricaoTransacao implements IStrategy {

	@Override
	public Resultado processar(IEntidadeDominio entidade) {

		Transacao transacao = (Transacao) entidade;
		char[] chaveUnica = transacao.getChaveUnica().toCharArray();
		String descricao = "transaction ".concat(algoritmoGeraDescricao(chaveUnica));

		transacao.setDescricao(descricao.toString());
		resultado.setErro(false);

		return resultado;
	}

	private String algoritmoGeraDescricao(char[] chaveUnica) {

		StringBuilder descricao = new StringBuilder();

		for (int i = 0, j = 1; i < chaveUnica.length; i++) {
			Integer valor = new Integer(new Character(chaveUnica[i]).toString());
			valor = valor == 0 ? valor + 1 : valor;

			if (i % 2 == 0) {

				if (isVogal(valor)) {
					valor++;
				}

				int va = (int) (valor + 96);
				if (va > 122) va = va - 122;
				char consoante = (char) va;
				descricao.append(consoante);

			} else {
				if (j > 5) j = j - 5;
				descricao.append(Vogais.getMapvogais().get(new Integer(j)));
				j++;
			}
		}
		return descricao.toString();
	}

	private boolean isVogal(Integer valorNumerico) {
		String vogal = Vogais.getMapvogais().get(valorNumerico);
		return vogal != null ? true : false;
	}

}
