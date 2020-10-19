package br.com.guiabolso.api.util;

import java.util.HashMap;
import java.util.Map;

public class Vogais {

	private static Map<Integer, String> mapVogais = new HashMap<>();
	
	static {
		mapVogais.put(1, "a");
		mapVogais.put(2, "e");
		mapVogais.put(3, "i");
		mapVogais.put(4, "o");
		mapVogais.put(5, "u");
	}


	public static Map<Integer, String> getMapvogais() {
		
		return mapVogais;
	}
}
