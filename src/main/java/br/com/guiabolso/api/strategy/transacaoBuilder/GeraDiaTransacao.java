package br.com.guiabolso.api.strategy.transacaoBuilder;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.springframework.stereotype.Component;

import br.com.guiabolso.api.domain.IEntidadeDominio;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.strategy.IStrategy;

@Component
public class GeraDiaTransacao implements IStrategy {

	@Override
	public Resultado processar(IEntidadeDominio entidade) {

		Transacao transacao = (Transacao) entidade;
		Random gerador = new Random();
		
		Long dia = new Long(Math.abs(gerador.nextInt())) % 30;

		if (transacao.getMes().equals(new Long(2)) && dia > 28)
			dia = new Long(28);
		
		if(dia == 0)
			dia += transacao.getMes();
		
		transacao.setData(dia);
		transacao.setDataCompleta(montaDataTransacao(transacao));
		
		resultado.setErro(false);
		return resultado;
	}

	private Timestamp montaDataTransacao(Transacao transacao) {

		String data = transacao.getData().toString().concat("/").concat(transacao.getMes().toString()).concat("/")
				.concat(transacao.getAno().toString());
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
