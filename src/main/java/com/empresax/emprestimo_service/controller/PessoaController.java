package com.empresax.emprestimo_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.empresax.emprestimo_service.entity.Pessoa;
import com.empresax.emprestimo_service.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }

}
