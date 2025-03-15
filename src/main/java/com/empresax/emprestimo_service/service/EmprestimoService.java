package com.empresax.emprestimo_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresax.emprestimo_service.entity.Emprestimo;
import com.empresax.emprestimo_service.entity.Pessoa;
import com.empresax.emprestimo_service.exception.EmprestimoInvalidoException;
import com.empresax.emprestimo_service.exception.PessoaNaoEncontradaException;
import com.empresax.emprestimo_service.repository.EmprestimoRepository;
import com.empresax.emprestimo_service.repository.PessoaRepository;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Emprestimo realizarEmprestimo(Long pessoaId, Double valorEmprestimo, Integer numeroParcelas) {
        // Verificar se a pessoa existe
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa não encontrada"));

        // Validar se o valor do empréstimo é válido
        if (valorEmprestimo <= 0) {
            throw new EmprestimoInvalidoException("O valor do empréstimo deve ser maior que zero.");
        }

        // Validar se o número de parcelas é válido
        if (numeroParcelas <= 0) {
            throw new EmprestimoInvalidoException("O número de parcelas deve ser maior que zero.");
        }

        // Criando o objeto de empréstimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setValorEmprestimo(valorEmprestimo);
        emprestimo.setNumeroParcelas(numeroParcelas);
        emprestimo.setStatusPagamento("Pendente");
        emprestimo.setDataCriacao(LocalDate.now());
        emprestimo.setPessoa(pessoa);

        // Salvando o empréstimo no repositório
        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> consultarEmprestimo() {
        return emprestimoRepository.findAll();
    }

    // Outros métodos CRUD
}
