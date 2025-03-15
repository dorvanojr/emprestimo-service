package com.empresax.emprestimo_service.entity;

import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String identificador;
    private LocalDate dataNascimento;
    private String tipoIdentificador;
    private Double valorMinMensal;
    private Double valorMaxEmprestimo;
    
    public Pessoa() {
		// TODO Auto-generated constructor stub
	}
}
