package br.com.appcadastrorest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appcadastrorest.data.entity.vo.PessoaVO;
import br.com.appcadastrorest.service.PessoaService;

@RestController
	@RequestMapping("/pessoa/v1")
	public class PessoaController {
		
		
		@Autowired
		PessoaService service;
		
		@GetMapping
		public List<PessoaVO> exibirPessoa() {
			return service.buscarTodos();
			
			
		}

		@GetMapping("/{id}")
		public PessoaVO exibirPessoaPorId(@PathVariable("id") Long idPessoa) {
			return service.buscarPorId(idPessoa);
			
			
		}
		
		@PostMapping()
		public PessoaVO inserirPessoa(@RequestBody PessoaVO pessoa) {
			return service.inserir(pessoa);
			
			
			
		}
		
		@PutMapping()
	public PessoaVO atualizarPessoa(@RequestBody PessoaVO pessoa) {
			
			return service.atualizar(pessoa);
		}
		
		@DeleteMapping("/{id}")
		
		public ResponseEntity<?> excluirPessoa(@PathVariable("id") Long idPessoa) {
			service.deletar(idPessoa);
			return ResponseEntity.ok().build();
			
		}
		
}
