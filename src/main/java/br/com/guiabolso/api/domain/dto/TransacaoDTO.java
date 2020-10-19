package br.com.guiabolso.api.domain.dto;

public class TransacaoDTO {

	private String descricao;
	private Long data;
	private Integer valor;
	private Boolean duplicated;
	private int dia;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getData() {
		return data;
	}
	public void setData(Long data) {
		this.data = data;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Boolean getDuplicated() {
		return duplicated;
	}
	public void setDuplicated(Boolean duplicated) {
		this.duplicated = duplicated;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	
	
}
