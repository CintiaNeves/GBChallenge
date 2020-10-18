package br.com.guiabolso.api.domain.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Resultado {

	private boolean erro;
	private String mensagem;
	private List<Transacao> transacoes;
	
	public boolean isErro() {
		return erro;
	}
	public void setErro(boolean erro) {
		this.erro = erro;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public List<Transacao> getTransacoes() {
		return transacoes;
	}
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
}
