package com.empresax.emprestimo_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresax.emprestimo_service.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {



}
