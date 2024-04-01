package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private float salario;
    @NotNull
    private float cargaHoraria;

    public Funcionario(String nome, String sobrenome, String cpf, String telefone, float salario, float cargaHoraria) {
        super(nome, sobrenome, cpf, telefone);
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
    }

    public Funcionario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}