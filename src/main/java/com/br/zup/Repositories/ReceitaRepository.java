package com.br.zup.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.Models.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Integer> {

}
