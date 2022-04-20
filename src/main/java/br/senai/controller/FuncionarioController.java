package br.senai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuncionarioController {

    @GetMapping("/funcionario/list")
    public String findAll(){
        return "funcionario/list";
    }
}
