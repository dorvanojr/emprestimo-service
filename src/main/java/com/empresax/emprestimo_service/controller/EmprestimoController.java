package com.empresax.emprestimo_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresax.emprestimo_service.entity.Emprestimo;
import com.empresax.emprestimo_service.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmprestimoController.class);

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public Emprestimo realizarEmprestimo(@RequestParam Long pessoaId, @RequestParam Double valorEmprestimo, @RequestParam Integer numeroParcelas) {
        return emprestimoService.realizarEmprestimo(pessoaId, valorEmprestimo, numeroParcelas);
    }
    
    @GetMapping("/testar")
    public String testar() {
    	logger.info("Endpoint /testar acessado");
    	return "oi";
    }
}
