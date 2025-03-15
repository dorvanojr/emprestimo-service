package com.empresax.emprestimo_service.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "O nome é obrigatório")
    @Size(min = 3, message = "O nome deve ter pelo menos 3 caracteres")
    private String nome;

    @NotNull(message = "O identificador é obrigatório")
    private String identificador;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @NotNull(message = "O tipo de identificador é obrigatório")
    private String tipoIdentificador;

    @NotNull(message = "O valor mínimo mensal é obrigatório")
    private Double valorMinMensal;

    @NotNull(message = "O valor máximo de empréstimo é obrigatório")
    private Double valorMaxEmprestimo;
}
