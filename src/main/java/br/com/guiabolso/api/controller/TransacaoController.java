package br.com.guiabolso.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.domain.entity.TransacaoInputData;
import br.com.guiabolso.api.domain.entity.Usuario;
import br.com.guiabolso.api.domain.model.TransacaoModel;
import br.com.guiabolso.api.domain.service.RequestService;
import br.com.guiabolso.api.domain.service.TransacaoService;

@RestController
@RequestMapping("/")
public class TransacaoController {
	
	@Autowired private RequestService requestService;
	@Autowired private TransacaoService transacaoService;
	@Autowired private ModelMapper modelMapper;
		
	@ResponseBody
	@GetMapping("/{id}/transacoes/{ano}/{mes}")
	public ResponseEntity<TransacaoModel> buscar(@PathVariable Long id, @PathVariable Long ano, @PathVariable Long mes){
		
		TransacaoInputData transacaoInputData = new TransacaoInputData();
		
		transacaoInputData.setAno(ano);
		transacaoInputData.setMes(mes);
		transacaoInputData.setUsuarioId(id);
		
		Resultado resultado = requestService.validar(transacaoInputData);
		Transacao transacao = new Transacao();
		Usuario usuario = new Usuario();
		
		
		if(!resultado.isErro()) {
			transacao.setAno(ano);
			transacao.setMes(mes);
			usuario.setId(id);
			transacao.setUsuario(usuario);
			transacaoService.processar(transacao);
		
		}else {
			transacao.setDescricao(resultado.getMensagem());
		}
		
		TransacaoModel transacaoModel = toModel(transacao);
		return ResponseEntity.ok(transacaoModel);
		
	}
	
	private TransacaoModel toModel(Transacao transacao) {
		return modelMapper.map(transacao, TransacaoModel.class);
	}
	
}
