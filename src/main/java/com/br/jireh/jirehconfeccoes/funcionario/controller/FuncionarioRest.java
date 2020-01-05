package com.br.jireh.jirehconfeccoes.funcionario.controller;

import com.br.jireh.jirehconfeccoes.funcionario.request.FuncionarioDTO;
import com.br.jireh.jirehconfeccoes.funcionario.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/funcionarios")
public class FuncionarioRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FuncionarioRest.class);

    private final FuncionarioService funcionarioService;

    public FuncionarioRest(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/save")
    public FuncionarioDTO save(@RequestBody FuncionarioDTO funcionarioDTO) {
        LOGGER.info("Receiving persistence solicitation of funcionario...");
        LOGGER.debug("Payload: {}", funcionarioDTO);

        return funcionarioService.save(funcionarioDTO);
    }

    @PutMapping("/update/{id}")
    public FuncionarioDTO update(@RequestBody FuncionarioDTO funcionarioDTO, @PathVariable Long id) {
        LOGGER.info("Receiving persistence solicitation of funcionario...");
        LOGGER.debug("Payload: {}", funcionarioDTO);

        return this.funcionarioService.update(funcionarioDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Receiving persistence solicitation of funcionario...");

        this.funcionarioService.deleteById(id);
    }
}
