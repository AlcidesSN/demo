package com.example.demo.service;

import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public boolean animalValidation(long id){
        return animalRepository.existsById(id);
    }
    public boolean funcionarioValidation(long id){
        return funcionarioRepository.existsById(id);
    }
}
