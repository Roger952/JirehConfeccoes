package com.br.jireh.jirehconfeccoes.fornecedor.controller;

import com.br.jireh.jirehconfeccoes.fornecedor.request.FornecedorDTO;
import com.br.jireh.jirehconfeccoes.fornecedor.service.FornecedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/fornecedor")
public class FornecedorRest {

    private final FornecedorService fornecedorService;

    public FornecedorRest(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

}
