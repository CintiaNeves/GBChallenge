package br.com.guiabolso.api.domain.entity;

import br.com.guiabolso.api.domain.IEntidadeDominio;

public class TransacaoInputData implements IEntidadeDominio{

	private int mes;
	private int ano;
	private Long usuarioId;
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	
}
