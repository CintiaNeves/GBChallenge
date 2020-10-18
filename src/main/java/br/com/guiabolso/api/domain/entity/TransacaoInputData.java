package br.com.guiabolso.api.domain.entity;

import br.com.guiabolso.api.domain.IEntidadeDominio;

public class TransacaoInputData implements IEntidadeDominio{

	private Long mes;
	private Long ano;
	private Long usuarioId;
	
	public Long getMes() {
		return mes;
	}
	public void setMes(Long mes) {
		this.mes = mes;
	}
	public Long getAno() {
		return ano;
	}
	public void setAno(Long ano) {
		this.ano = ano;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	
}
