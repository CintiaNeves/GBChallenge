package br.com.guiabolso.api.domain.enums;

public enum Ano {

	ANO_MINIMO(1900), ANO_MAXIMO(2020);

	public int valorAno;

	Ano(int valor) {
		this.valorAno = valor;
	}
}
