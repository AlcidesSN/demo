package com.example.demo.controller;

import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    AnimalService animalService;


    @GetMapping
    public List<Animal> listar(){return animalService.listar();}

    @PostMapping
    public Animal criar(@Valid @RequestBody Animal animal){return animalService.criar(animal);}

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@Valid @RequestBody Animal animal, @PathVariable long id){
        if(animalService.atualizar(animal,id) == null){
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(animal);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        if(animalService.deletar(id)){
            String msg = "O id " + id + " foi deletado com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }else {
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        }
    }
    @GetMapping("/{id}")
    public Optional<Animal> buscaid(@PathVariable long id){
        return animalService.buscaid(id);
    }
}
