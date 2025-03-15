package com.empresax.emprestimo_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Exceção genérica
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Erro interno do servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Exceção quando o recurso não for encontrado (ex: 404)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException e) {
        return new ResponseEntity<>("Recurso não encontrado: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Exceção personalizada para erros de validação
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        return new ResponseEntity<>("Erro de validação: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(PessoaNaoEncontradaException.class)
    public ResponseEntity<String> handlePessoaNaoEncontradaException(PessoaNaoEncontradaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Tratamento para exceções de "Empréstimo inválido"
    @ExceptionHandler(EmprestimoInvalidoException.class)
    public ResponseEntity<String> handleEmprestimoInvalidoException(EmprestimoInvalidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Remova a duplicidade de Exception handling
    // @ExceptionHandler(Exception.class) - Essa já foi coberta acima.
}
