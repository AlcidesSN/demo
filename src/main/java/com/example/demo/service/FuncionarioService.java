package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService implements PessoaService<Funcionario>{
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }
    @Override
    public Funcionario criar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario, long id){
        if(verificaid(id)){
            //verdadeiro
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        }
        //false
        return null;
    }
    @Override
    public boolean deletar(long id){
        if(verificaid(id)){
            funcionarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
    public int qtdFuncionarios(){
        return funcionarioRepository.findAll().size();
    }
    public Optional<Funcionario> buscaid(long id){
        return funcionarioRepository.findById(id);
    }
    private boolean verificaid(long id){
        return funcionarioRepository.existsById(id);
    }
}
