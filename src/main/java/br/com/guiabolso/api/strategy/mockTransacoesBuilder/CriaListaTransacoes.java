package br.com.guiabolso.api.strategy.mockTransacoesBuilder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.domain.entity.Usuario;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class CriaListaTransacoes implements IStrategy {

	@Override
	public Resultado processar(IEntidadeDominio entidade) {

		Transacao transacaoMolde = (Transacao) entidade;
		List<Transacao> transacoes = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			Transacao t = new Transacao();
			Usuario u = new Usuario();

			t.setAno(transacaoMolde.getAno());
			t.setMes(transacaoMolde.getMes());
			t.setDuplicated(false);
			u.setId(transacaoMolde.getUsuario().getId());
			t.setUsuario(u);

			transacoes.add(t);
		}
		resultado.setTransacoes(transacoes);
		resultado.setErro(false);
		return resultado;
	}
	

}
