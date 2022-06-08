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

    @Override
    public List<Projeto> findAll(){
        return projetoRepository.findAll();
    }

    @Override
    public Projeto findById(Long id){
        Projeto findProjeto = projetoRepository.findById(id).get();
        return findProjeto != null ? findProjeto : new Projeto();
    }

    @Override
    public Projeto save(Projeto projeto){
        try{
            return projetoRepository.save(projeto);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try{
            projetoRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
    }
}
