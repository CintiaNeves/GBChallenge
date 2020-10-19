package br.com.guiabolso.api.domain.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockTransacoes {

	private static Map<String, List<Transacao>> mapTransacoes = new HashMap<>();
	
	public static Map<String, List<Transacao>> getMapTransacoes() {
		return mapTransacoes;
	}

	public static void setMapTransacoes(Map<String, List<Transacao>> mapTransacoes) {
		MockTransacoes.mapTransacoes = mapTransacoes;
	}
	
}
