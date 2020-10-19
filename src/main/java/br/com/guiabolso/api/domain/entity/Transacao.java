package br.com.guiabolso.api.domain.entity;

import br.com.guiabolso.api.domain.IEntidadeDominio;

public class Transacao implements IEntidadeDominio{

	private Usuario usuario;
	private String descricao;
	private Integer valor;
	private Boolean duplicated;
	private int dia;
	private int mes;
	private int ano;
	private Long data;
	private String chaveUnica;
	private String chaveRequisicao;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public String getChaveUnica() {
		return chaveUnica;
	}

	public void setChaveUnica(String chaveUnica) {
		this.chaveUnica = chaveUnica;
	}

	public String getChaveRequisicao() {
		return chaveRequisicao;
	}

	public void setChaveRequisicao(String chaveRequisicao) {
		this.chaveRequisicao = chaveRequisicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}	
}
