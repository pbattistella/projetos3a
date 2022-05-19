package br.senai.service;

import br.senai.model.Funcionario;
import br.senai.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario findByNome(String nome) {
        return null;
    }

    @Override
    public Funcionario findById(Long id){
        Funcionario func = funcionarioRepository.findById(id).get();
        return func != null ? func : new Funcionario();
    }

    @Override
    public Funcionario save(Funcionario funcionario){
        try{
            return funcionarioRepository.save(funcionario);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteById(Long id){
        try{
            funcionarioRepository.deleteById(id);
        } catch(Exception e){
            throw  e;
        }
    }
}
