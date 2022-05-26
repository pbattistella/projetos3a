package br.senai.controller;

import br.senai.model.Projeto;
import br.senai.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjetoController {
    @Autowired
    ProjetoServiceImpl projetoService;

    @GetMapping("/projeto/list")
    public String findAll(Model model){
        model.addAttribute("projetos", projetoService.findAll());
        return "projeto/list";
    }

    @GetMapping("/projeto/add")
    public String add(Model model){
        model.addAttribute("projeto", new Projeto());
        return "projeto/add";
    }

}
