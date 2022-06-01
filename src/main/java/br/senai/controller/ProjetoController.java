package br.senai.controller;

import br.senai.model.Projeto;
import br.senai.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/projeto/save")
    public String save(Projeto projeto, Model model){
        try{
            Projeto saveProjeto = projetoService.save(projeto);
            model.addAttribute("projeto", saveProjeto);
            model.addAttribute("isSaved",true);
            model.addAttribute("isError",false);
        }catch (Exception e){
            model.addAttribute("projeto", projeto);
            model.addAttribute("isSaved",false);
            model.addAttribute("isError",true);
        }
        return "projeto/add";
    }



}
