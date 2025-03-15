package com.empresax.emprestimo_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresax.emprestimo_service.entity.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
   
	Pessoa findByIdentificador(String identificador);
    
    
}
