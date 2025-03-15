package com.empresax.emprestimo_service.entity;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class Emprestimo {
    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorEmprestimo;
    private Integer numeroParcelas;
    private String statusPagamento;
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    
    public Emprestimo() {
		// TODO Auto-generated constructor stub
	}

}
