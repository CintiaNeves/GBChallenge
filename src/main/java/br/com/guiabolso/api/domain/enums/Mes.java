package br.com.guiabolso.api.domain.enums;

public enum Mes {

	MES_MINIMO(1), MES_MAXIMO(12);
	
	public int valorMes;
	
	Mes(int valor) {
		this.valorMes = valor;
	}
}
