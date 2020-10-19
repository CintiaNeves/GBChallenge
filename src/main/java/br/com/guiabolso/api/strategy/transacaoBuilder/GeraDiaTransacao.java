package br.com.guiabolso.api.strategy.transacaoBuilder;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.MockTransacoes;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class GeraDiaTransacao implements IStrategy {

	@Override
	public Resultado processar(IEntidadeDominio entidade) {

		Transacao transacao = (Transacao) entidade;
		Random gerador = new Random();
		
		int mesAtual = MockTransacoes.getDataDeHoje().getMonthValue();
		int anoAtual = MockTransacoes.getDataDeHoje().getYear();
		int diaAtual = MockTransacoes.getDataDeHoje().getDayOfMonth();
		
		int dia = 1;
		
		if(transacao.getMes() == mesAtual && transacao.getAno() == anoAtual) {
			dia = Math.abs(gerador.nextInt()) % diaAtual;
		}else {
			dia = Math.abs(gerador.nextInt()) % 30;
		}
			
		if (transacao.getMes() == 2 && dia > 28)
			dia = 28;
		
		if(dia == 0)
			dia += transacao.getMes();
		
		transacao.setDia(dia);
		transacao.setData(montaDataTransacao(transacao).getTime());
	
		resultado.setErro(false);
		return resultado;
	}

	private Timestamp montaDataTransacao(Transacao transacao) {

		String data = String.valueOf(transacao.getDia()).concat("/").concat(String.valueOf(transacao.getMes())).concat("/")
				.concat(String.valueOf(transacao.getAno()));
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		
		try {
			date = dateFormat.parse(data);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		long time = date.getTime();
		return new Timestamp(time);
	}

}
