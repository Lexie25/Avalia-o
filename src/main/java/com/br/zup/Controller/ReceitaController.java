package com.br.zup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.Models.Receita;
import com.br.zup.Service.ReceitaService;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@PostMapping
	public ResponseEntity<?> criarReceita(@RequestBody Receita receita){
		return ResponseEntity.status(HttpStatus.CREATED).body(receitaService.criarReceita(receita));
	}

	@GetMapping
	public ResponseEntity<?>listaDeReceita(){
		return ResponseEntity.ok(receitaService.listaDeReceita());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Receita> buscarReceita(@PathVariable int id){
		Receita receitaObj = receitaService.buscarReceita(id);
		if(receitaObj == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(receitaObj);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Receita> atualizarReceita(@PathVariable int id, @RequestBody Receita receita){
		receitaService.atualizarReceita(id , receita);
		return ResponseEntity.ok(receita);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarReceita(@PathVariable int id){
		receitaService.deletarReceita(id);
		return ResponseEntity.ok().build();
	}
}




















