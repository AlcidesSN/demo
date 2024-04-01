package com.example.demo.service;

import com.example.demo.model.Agendamento;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private ValidationService validationService;

    public List<Agendamento> listar(){
        return agendamentoRepository.findAll();
    }
    public Agendamento criar(Agendamento agendamento){
        if(!validationService.animalValidation(agendamento.getAnimal()))
            return null;
        if(!validationService.funcionarioValidation(agendamento.getFuncionario()))
            return null;
        return agendamentoRepository.save(agendamento);
    }
    public Agendamento atualizar(Agendamento agendamento, long id){
        if(verificaid(id)){
            //verdadeiro
            agendamento.setId(id);
            return agendamentoRepository.save(agendamento);
        }
        //false
        return null;
    }
    public boolean deletar(long id) {
        if(verificaid(id)){
            agendamentoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Agendamento> buscaid(long id){
        return agendamentoRepository.findById(id);
    }
    private boolean verificaid(long id){
        return agendamentoRepository.existsById(id);
    }
}
