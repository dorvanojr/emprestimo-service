package com.empresax.emprestimo_service.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emprestimos") // <- Opcional, define um nome para a tabela no banco
public class Emprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorEmprestimo;
    private Integer numeroParcelas;
    private String statusPagamento;
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}
