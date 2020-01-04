package com.br.jireh.jirehconfeccoes.funcionario.controller;

import com.br.jireh.jirehconfeccoes.funcionario.service.FuncionarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/fornecedor")
public class FuncionarioRest {

    private final FuncionarioService funcionarioService;

    public FuncionarioRest(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

}
