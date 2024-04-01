package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import javax.swing.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private long animal;
    private String residencia;

    public Cliente(String nome, String sobrenome, String cpf, String telefone, long id, long animal, String residencia) {
        super(nome, sobrenome, cpf, telefone);
        this.id = id;
        this.animal = animal;
        this.residencia = residencia;
    }

    public Cliente() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAnimal() {
        return animal;
    }

    public void setAnimal(long animal) {
        this.animal = animal;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }
}
