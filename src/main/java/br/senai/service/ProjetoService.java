package br.senai.service;

import br.senai.model.Projeto;

import java.util.List;

public interface ProjetoService {
    List<Projeto> findAll();
    Projeto save(Projeto projeto);
}
