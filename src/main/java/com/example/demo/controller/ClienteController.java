package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @PostMapping
    public Cliente criar(@Valid @RequestBody Cliente cliente) {
        return clienteService.criar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Long id){
        if(clienteService.atualizar(cliente,id) == null){
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(cliente);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        if(clienteService.deletar(id)){
            String msg = "O id " + id + " foi deletado com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }else {
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        }
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscaid(@PathVariable long id){
        return clienteService.buscaid(id);
    }
}
