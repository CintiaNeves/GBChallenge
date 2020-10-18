package br.com.guiabolso.api.domain.entity;

import org.springframework.stereotype.Component;

@Component
public class Resultado {

	private boolean erro;
	private String mensagem;
	
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
	
	
}
