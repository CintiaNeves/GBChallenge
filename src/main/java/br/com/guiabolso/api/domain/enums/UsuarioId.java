package br.com.guiabolso.api.domain.enums;

public enum UsuarioId {

	ID_MINIMO(1000), ID_MAXIMO(100000000);
	
	public int valorId;
	
	UsuarioId(int valor) {
		this.valorId = valor;
	}

}
