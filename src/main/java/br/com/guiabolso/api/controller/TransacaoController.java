package br.com.guiabolso.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.guiabolso.api.domain.dto.TransacaoDTO;
import br.com.guiabolso.api.domain.entity.Resultado;
import br.com.guiabolso.api.domain.entity.Transacao;
import br.com.guiabolso.api.domain.entity.TransacaoInputData;
import br.com.guiabolso.api.domain.entity.Usuario;
import br.com.guiabolso.api.service.MockTransacoesService;
import br.com.guiabolso.api.service.RequestService;

@RestController
@RequestMapping("/")
public class TransacaoController {

	@Autowired private RequestService requestService;
	@Autowired private ModelMapper modelMapper;
	@Autowired private MockTransacoesService mockTransacoesService;
		
	@ResponseBody
	@GetMapping("/{id}/transacoes/{ano}/{mes}")
	public ResponseEntity<List<TransacaoDTO>> listar(@PathVariable Long id, @PathVariable int ano, @PathVariable int mes) {

		TransacaoInputData transacaoInputData = new TransacaoInputData();
		transacaoInputData.setAno(ano);
		transacaoInputData.setMes(mes);
		transacaoInputData.setUsuarioId(id);

		Resultado resultado = requestService.validar(transacaoInputData);
		
		if(!resultado.isErro()) {
			Transacao transacao = new Transacao();
			Usuario usuario = new Usuario();
			
			transacao.setAno(ano);
			transacao.setMes(mes);
			usuario.setId(id);
			transacao.setUsuario(usuario);
			
			resultado = mockTransacoesService.buscar(transacao);
			
			if(resultado.getTransacoes() == null)
				mockTransacoesService.criar(transacao);
			
			return ResponseEntity.ok(toCollectionModel(mockTransacoesService.listar(transacao.getChaveRequisicao())));
		}
			
		return ResponseEntity.notFound().build();
	}
	
	@ResponseBody
	@GetMapping("/")
	public ResponseEntity<Resultado> inicio(){
		
		return ResponseEntity.notFound().build();
	}
	
	private List<TransacaoDTO> toCollectionModel(List<Transacao> transacoes) {
		return transacoes.stream().map(transacao -> toModel(transacao)).collect(Collectors.toList());
	}

	private TransacaoDTO toModel(Transacao transacao) {
		return modelMapper.map(transacao, TransacaoDTO.class);
	}

}
