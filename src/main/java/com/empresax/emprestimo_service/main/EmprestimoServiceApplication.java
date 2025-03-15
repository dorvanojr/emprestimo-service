package com.empresax.emprestimo_service.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "com.empresax.emprestimo_service") // Explicitly scan this package
@EntityScan(basePackages = "com.empresax.emprestimo_service.entity") // Add this line
@EnableJpaRepositories(basePackages = "com.empresax.emprestimo_service.repository")
public class EmprestimoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmprestimoServiceApplication.class, args);
    }
}