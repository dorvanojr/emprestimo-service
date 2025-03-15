package com.empresax.emprestimo_service.service;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.empresax.emprestimo_service.entity.Pessoa;
import com.empresax.emprestimo_service.repository.PessoaRepository;

@SpringBootTest
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    public void testCriarPessoaPF() {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdentificador("12345678901");

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa savedPessoa = pessoaService.criarPessoa(pessoa);

        assertEquals("PF", savedPessoa.getTipoIdentificador());
        assertEquals(300.00, savedPessoa.getValorMinMensal());
        assertEquals(10000.00, savedPessoa.getValorMaxEmprestimo());
    }

    // Outros testes
}