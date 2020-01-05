package com.br.jireh.jirehconfeccoes.mercadoria.controller;

import com.br.jireh.jirehconfeccoes.mercadoria.request.MercadoriaDTO;
import com.br.jireh.jirehconfeccoes.mercadoria.service.MercadoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/mercadorias")
public class MercadoriaRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MercadoriaRest.class);

    private final MercadoriaService mercadoriaService;

    @Autowired
    public MercadoriaRest(MercadoriaService mercadoriaService) {
        this.mercadoriaService = mercadoriaService;
    }

    @PostMapping("/save")
    public MercadoriaDTO save(MercadoriaDTO mercadoriaDTO) {
        LOGGER.info("Receiving persistence solicitation of mercadoria...");
        LOGGER.debug("Payload: {}", mercadoriaDTO);

        return this.mercadoriaService.save(mercadoriaDTO);
    }

    @PutMapping("/update/{id}")
    public MercadoriaDTO update(MercadoriaDTO mercadoriaDTO, @PathVariable Long id) {
        LOGGER.info("Receiving persistence solicitation of mercadoria...");
        LOGGER.debug("Payload: {}", mercadoriaDTO);

        return this.mercadoriaService.update(mercadoriaDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Receiving persistence solicitation of mercadoria...");

        this.mercadoriaService.deleteById(id);
    }
}
