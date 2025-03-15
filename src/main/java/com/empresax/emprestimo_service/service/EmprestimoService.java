package com.empresax.emprestimo_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresax.emprestimo_service.entity.Emprestimo;
import com.empresax.emprestimo_service.entity.Pessoa;
import com.empresax.emprestimo_service.repository.EmprestimoRepository;
import com.empresax.emprestimo_service.repository.PessoaRepository;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Emprestimo realizarEmprestimo(Long pessoaId, Double valorEmprestimo, Integer numeroParcelas) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setValorEmprestimo(valorEmprestimo);
        emprestimo.setNumeroParcelas(numeroParcelas);
        emprestimo.setStatusPagamento("Pendente");
        emprestimo.setDataCriacao(LocalDate.now());
        emprestimo.setPessoa(pessoa);

        return emprestimoRepository.save(emprestimo);
    }
    
    
    public List<Emprestimo> consultarEmprestimo(){
    	return emprestimoRepository.findAll();
    }

    // Outros métodos CRUD
}
