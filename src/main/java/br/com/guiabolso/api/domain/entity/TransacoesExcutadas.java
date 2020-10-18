package br.com.guiabolso.api.domain.entity;

import java.util.HashMap;
import java.util.Map;

public class TransacoesExcutadas {

	private static Map<String, Transacao> transacoes = new HashMap<>();

	public static Map<String, Transacao> getTransacoes() {
		return transacoes;
	}

	public static void setTransacoes(Map<String, Transacao> transacoes) {
		TransacoesExcutadas.transacoes = transacoes;
	}

	

	
}
