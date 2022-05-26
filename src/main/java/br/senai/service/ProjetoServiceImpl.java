package br.senai.service;

import br.senai.model.Projeto;
import br.senai.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService{
    @Autowired
    ProjetoRepository projetoRepository;

    public List<Projeto> findAll(){
        return projetoRepository.findAll();
    }

    public Projeto save(Projeto projeto){
        return null;
    }
}
