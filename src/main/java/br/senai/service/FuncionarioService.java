package br.senai.service;

import br.senai.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> findAll();
    public Funcionario findById(Long id);
    public Funcionario findByNome(String nome);
    public Funcionario save(Funcionario funcionario);
    public void deleteById(Long id);


}
