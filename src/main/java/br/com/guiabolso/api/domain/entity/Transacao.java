package br.com.guiabolso.api.domain.entity;

import java.sql.Timestamp;

import br.com.guiabolso.api.domain.IEntidadeDominio;

public class Transacao implements IEntidadeDominio{

	private Usuario usuario;
	private String descricao;
	private Integer valor;
	private Boolean duplicated;
	private Long mes;
	private Long ano;
	private Long data;
	private String chaveUnica;
	private String chaveRequisicao;
	private Timestamp dataCompleta;
	private int index;

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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getDuplicated() {
		return duplicated;
	}

	public void setDuplicated(Boolean duplicated) {
		this.duplicated = duplicated;
	}
	
	
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
	
	public String getChaveUnica() {
		return chaveUnica;
	}

	public void setChaveUnica(String chaveUnica) {
		this.chaveUnica = chaveUnica;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public Timestamp getDataCompleta() {
		return dataCompleta;
	}

	public void setDataCompleta(Timestamp dataCompleta) {
		this.dataCompleta = dataCompleta;
	}
	
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
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
		result = prime * result + ((dataCompleta == null) ? 0 : dataCompleta.hashCode());
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
		if (dataCompleta == null) {
			if (other.dataCompleta != null)
				return false;
		} else if (!dataCompleta.equals(other.dataCompleta))
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
