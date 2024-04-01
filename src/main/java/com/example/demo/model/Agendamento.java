package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String sevico;
    @NotNull
    private long animal;
    @NotNull
    private long funcionario;
    @NotNull
    private String data;

    public Agendamento(Long id, String sevico, long animal, long funcionario, String data) {
        this.id = id;
        this.sevico = sevico;
        this.animal = animal;
        this.funcionario = funcionario;
        this.data = data;
    }

    public Agendamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSevico() {
        return sevico;
    }

    public void setSevico(String sevico) {
        this.sevico = sevico;
    }

    public long getAnimal() {
        return animal;
    }

    public void setAnimal(long animal) {
        this.animal = animal;
    }

    public long getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(long funcionario) {
        this.funcionario = funcionario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
