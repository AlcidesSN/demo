package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;
    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioService.listar();
    }

    @PostMapping
    public Funcionario criar(@Valid @RequestBody Funcionario funcionario) {
        return funcionarioService.criar(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@Valid @RequestBody Funcionario funcionario, @PathVariable Long id){
        if(funcionarioService.atualizar(funcionario,id) == null){
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(funcionario);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        if(funcionarioService.deletar(id)){
            String msg = "O id " + id + " foi deletado com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }else {
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        }
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> buscaid(@PathVariable long id){
        return funcionarioService.buscaid(id);
    }
}
