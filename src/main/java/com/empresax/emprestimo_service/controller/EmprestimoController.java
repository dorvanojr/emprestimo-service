package com.empresax.emprestimo_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.empresax.emprestimo_service.entity.Emprestimo;
import com.empresax.emprestimo_service.service.EmprestimoService;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Emprestimo> realizarEmprestimo(
            @RequestParam @NotNull(message = "O campo pessoaId é obrigatório") Long pessoaId,
            @RequestParam @NotNull(message = "O campo valorEmprestimo é obrigatório") Double valorEmprestimo,
            @RequestParam @NotNull(message = "O campo numeroParcelas é obrigatório") Integer numeroParcelas) {

        // Validação adicional
        if (pessoaId <= 0 || valorEmprestimo <= 0 || numeroParcelas <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(emprestimoService.realizarEmprestimo(pessoaId, valorEmprestimo, numeroParcelas));
    }
    
    
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Emprestimo>> testar() {
	     return ResponseEntity.ok(emprestimoService.consultarEmprestimo());

	}
}
