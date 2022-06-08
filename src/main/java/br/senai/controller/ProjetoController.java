package br.senai.controller;

import br.senai.model.Projeto;
import br.senai.service.FuncionarioService;
import br.senai.service.FuncionarioServiceImpl;
import br.senai.service.ProjetoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjetoController {
    @Autowired
    ProjetoServiceImpl projetoService;

    @Autowired
    FuncionarioServiceImpl funcionarioService;

    @GetMapping("/projeto/list")
    public String findAll(Model model){
        model.addAttribute("projetos", projetoService.findAll());
        return "projeto/list";
    }

    @GetMapping("/projeto/add")
    public String add(Model model){
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "projeto/add";
    }

    @GetMapping("/projeto/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("projeto", projetoService.findById(id));
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "projeto/edit";
    }

    @PostMapping("/projeto/save")
    public String save(Projeto projeto, Model model){
        try{
            Projeto saveProjeto = projetoService.save(projeto);
            model.addAttribute("projeto", saveProjeto);
            model.addAttribute("funcionarios", funcionarioService.findAll());
            model.addAttribute("isSaved",true);
            model.addAttribute("isError",false);
        }catch (Exception e){
            model.addAttribute("projeto", projeto);
            model.addAttribute("funcionarios", funcionarioService.findAll());
            model.addAttribute("isSaved",false);
            model.addAttribute("isError",true);
        }
        return "projeto/add";
    }

    @GetMapping("/projeto/delete/{id}")
    public String delete(@PathVariable Long id){
        try{
            projetoService.deleteById(id);
        }catch (Exception e){
            System.out.println("Erro ao deletar o registro. "+ e.getMessage());
        }

        return "redirect: /projeto/list";
    }



}
