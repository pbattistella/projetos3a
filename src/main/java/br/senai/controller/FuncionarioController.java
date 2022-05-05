package br.senai.controller;

import br.senai.model.Funcionario;
import br.senai.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/funcionario/list")
    public String findAll(Model model){
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "funcionario/list";
    }

    @GetMapping("/funcionario/add")
    public String add(Model model){
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/add";
    }

    @PostMapping("/funcionario/save")
    public String save(Funcionario funcionario, Model model){
        try{
            funcionarioService.save(funcionario);
            model.addAttribute("funcionario", funcionario);
            model.addAttribute("isSaved",true);
            return "funcionario/add";
        } catch (Exception e){
            model.addAttribute("funcionario", funcionario);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());
            return "funcionario/add";
        }
    }



}
