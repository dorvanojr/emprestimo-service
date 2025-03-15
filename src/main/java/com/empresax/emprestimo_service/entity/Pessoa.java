package com.empresax.emprestimo_service.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoas") // Opcional, define um nome para a tabela no banco
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
}
