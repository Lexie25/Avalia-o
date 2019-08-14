package com.br.zup.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.Models.Receita;
import com.br.zup.Repositories.ReceitaRepository;

@Service
public class ReceitaService {
	@Autowired
	private ReceitaRepository receitaRepository;
	
	public Iterable<Receita> listaDeReceita () {
		return receitaRepository.findAll();
	}

	public Receita criarReceita(Receita receita) {
		receitaRepository.save(receita);
		return receita;
	}
	
	public Receita buscarReceita(int id) {
		if(receitaRepository.existsById(id)) {
			return receitaRepository.findById(id).get();
		}
		return null;
	}
	public void atualizarReceita(int id, Receita receita) {
		receita.setId(id);
		receitaRepository.save(receita);
	}
	
	public void deletarReceita(int id) {
		receitaRepository.deleteById(id);
	}
	
}
