package com.example.demo.controller;

import com.example.demo.model.Agendamento;
import com.example.demo.model.Funcionario;
import com.example.demo.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    AgendamentoService agendamentoService;

    @GetMapping
    public List<Agendamento> listar(){return agendamentoService.listar();}

    @PostMapping
    public Agendamento criar(@Valid @RequestBody Agendamento agendamento){return agendamentoService.criar(agendamento);}

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@Valid @RequestBody Agendamento agendamento,@PathVariable long id){
        if(agendamentoService.atualizar(agendamento,id) == null){
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(agendamento);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        if(agendamentoService.deletar(id)){
            String msg = "O id " + id + " foi deletado com sucesso";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }else {
            String mensagem = "O id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        }
    }
    @GetMapping("/{id}")
    public Optional<Agendamento> buscaid(@PathVariable long id){
        return agendamentoService.buscaid(id);
    }
}
