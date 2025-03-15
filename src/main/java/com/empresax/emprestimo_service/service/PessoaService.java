package com.empresax.emprestimo_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresax.emprestimo_service.entity.Pessoa;
import com.empresax.emprestimo_service.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        // Lógica para definir o tipoIdentificador e valores mínimos/máximos
        String identificador = pessoa.getIdentificador();
        if (identificador.length() == 11) {
            pessoa.setTipoIdentificador("PF");
            pessoa.setValorMinMensal(300.00);
            pessoa.setValorMaxEmprestimo(10000.00);
        } else if (identificador.length() == 14) {
            pessoa.setTipoIdentificador("PJ");
            pessoa.setValorMinMensal(1000.00);
            pessoa.setValorMaxEmprestimo(100000.00);
        } else if (identificador.length() == 8) {
            pessoa.setTipoIdentificador("EU");
            pessoa.setValorMinMensal(100.00);
            pessoa.setValorMaxEmprestimo(10000.00);
        } else if (identificador.length() == 10) {
            pessoa.setTipoIdentificador("AP");
            pessoa.setValorMinMensal(400.00);
            pessoa.setValorMaxEmprestimo(25000.00);
        }
        return pessoaRepository.save(pessoa);
    }

    // Outros métodos CRUD
}
