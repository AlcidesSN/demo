package com.example.demo.service;


import com.example.demo.model.Agendamento;
import com.example.demo.model.Animal;
import com.example.demo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;
    public List<Animal> listar(){
        return animalRepository.findAll();
    }
    public Animal criar(Animal animal){
        return animalRepository.save(animal);
    }
    public Animal atualizar(Animal animal, long id){

        if(verificaid(id)){
            //verdadeiro
            animal.setId(id);
            return animalRepository.save(animal);
        }
        //false
        return null;
    }
    public boolean deletar(long id) {
        if(verificaid(id)){
            animalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public Optional<Animal> buscaid(long id){
        return animalRepository.findById(id);
    }
    private boolean verificaid(long id){
        return animalRepository.existsById(id);
    }
}
