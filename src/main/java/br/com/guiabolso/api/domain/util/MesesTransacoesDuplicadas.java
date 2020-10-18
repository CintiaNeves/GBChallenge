package br.com.guiabolso.api.domain.util;

import java.util.HashMap;
import java.util.Map;

public class MesesTransacoesDuplicadas {

private static Map<Integer, Long> mapMeses = new HashMap<>();
	
	static {
		mapMeses.put(1, new Long(4));
		mapMeses.put(2, new Long(7));
		mapMeses.put(3, new Long(9));
	}


	public static Map<Integer, Long> getmapMeses() {
		return mapMeses;
	}
}
