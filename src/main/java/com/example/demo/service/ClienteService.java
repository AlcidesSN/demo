package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Funcionario;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteService implements PessoaService<Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente, long id) {
        if(verificaid(id)){
            //verdadeiro
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        //false
        return null;
    }

    @Override
    public boolean deletar(long id) {
        if(verificaid(id)){
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Cliente> buscaid(long id){
        return clienteRepository.findById(id);
    }
    private boolean verificaid(long id){
        return clienteRepository.existsById(id);
    }
}
