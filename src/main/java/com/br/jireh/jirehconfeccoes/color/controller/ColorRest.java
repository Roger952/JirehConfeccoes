package com.br.jireh.jirehconfeccoes.color.controller;

import com.br.jireh.jirehconfeccoes.color.model.Color;
import com.br.jireh.jirehconfeccoes.color.request.ColorDTO;
import com.br.jireh.jirehconfeccoes.color.service.ColorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cores")
public class ColorRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ColorRest.class);

    private final ColorService colorService;

    @Autowired
    public ColorRest(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping("/save")
    public ColorDTO save(ColorDTO colorDTO) {
        LOGGER.info("Receiving persistence solicitation of Cor...");
        LOGGER.debug("Payload: {}", colorDTO);

        return this.colorService.save(colorDTO);
    }

    @PutMapping("/update/{id}")
    public ColorDTO update(ColorDTO colorDTO, @PathVariable Long id) {
        LOGGER.info("Receiving persistence solicitation of Cor...");
        LOGGER.debug("Payload: {}", colorDTO);

        return this.colorService.update(colorDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("Receiving persistence solicitation of Cor...");

        this.colorService.deleteById(id);
    }

    @GetMapping("/finAll")
    public List<Color> findAll() {
        LOGGER.info("Receiving persistence solicitation of Cor...");

        return this.colorService.findAll();
    }
}
