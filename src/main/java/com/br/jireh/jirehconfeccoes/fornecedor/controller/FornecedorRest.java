package com.br.jireh.jirehconfeccoes.fornecedor.controller;

import com.br.jireh.jirehconfeccoes.fornecedor.model.Fornecedor;
import com.br.jireh.jirehconfeccoes.fornecedor.request.FornecedorDTO;
import com.br.jireh.jirehconfeccoes.fornecedor.service.FornecedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
@RequestMapping("/fornecedores")
public class FornecedorRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FornecedorRest.class);

    private final FornecedorService fornecedorService;

    @Autowired
    public FornecedorRest(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping("/save")
    public FornecedorDTO save(@RequestBody FornecedorDTO fornecedorDTO){
        LOGGER.info("Receiving persistence solicitation of fornecedor...");
        LOGGER.debug("Payload: {}", fornecedorDTO);

        return this.fornecedorService.save(fornecedorDTO);
    }

    @PutMapping("/update/{id}")
    public FornecedorDTO update(@RequestBody FornecedorDTO fornecedorDTO,@PathVariable(value = "id") Long id){
        LOGGER.info("Receiving persistence solicitation of fornecedor...");
        LOGGER.debug("Payload: {}", fornecedorDTO);

        return this.fornecedorService.update(fornecedorDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        LOGGER.info("Receiving persistence solicitation of fornecedor...");

        this.fornecedorService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Fornecedor findById(@PathVariable(value = "id") Long id){
        return fornecedorService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Fornecedor> findAll(){
        return fornecedorService.findAll();
    }
}
