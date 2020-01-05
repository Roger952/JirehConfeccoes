package com.br.jireh.jirehconfeccoes.color.service;

import com.br.jireh.jirehconfeccoes.color.database.IColorRepository;
import com.br.jireh.jirehconfeccoes.color.model.Color;
import com.br.jireh.jirehconfeccoes.color.request.ColorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {
    private static Logger LOGGER = LoggerFactory.getLogger(ColorService.class);

    private final IColorRepository iColorRepository;

    public ColorService(IColorRepository iColorRepository) {
        this.iColorRepository = iColorRepository;
    }

    private void validate(ColorDTO colorDTO) {

        LOGGER.info("Validando os produtos");

        if (colorDTO.getCodCor().isEmpty()) {
            throw new IllegalArgumentException("Informe o codigo da cor");
        } else if (iColorRepository.existsByCodCor(colorDTO.getCodCor())) {
            throw new IllegalArgumentException("Este codigo já existe");
        }
        if (colorDTO.getNomeCor().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome da cor");
        } else if (iColorRepository.existsByNomeCor(colorDTO.getNomeCor())) {
            throw new IllegalArgumentException("Já existe uma cor com este nome");
        }
    }

    public ColorDTO save(ColorDTO colorDTO) {
        Color color = new Color();

        LOGGER.info("Salvando a cor");

        validate(colorDTO);

        color.setCodCor(colorDTO.getCodCor());
        color.setNomeCor(colorDTO.getNomeCor());

        color = iColorRepository.save(color);

        return ColorDTO.of(color);
    }

    public ColorDTO update(ColorDTO colorDTO, Long id) {

        Optional<Color> optionalColor = iColorRepository.findById(id);

        validate(colorDTO);

        Color color;
        if (optionalColor.isPresent()) {
            color = optionalColor.get();

            LOGGER.info("Atualizando oa cor");

            color.setCodCor(colorDTO.getCodCor());
            color.setNomeCor(colorDTO.getNomeCor());

            color = iColorRepository.save(color);

            return ColorDTO.of(color);
        }

        throw new IllegalArgumentException("Esta cor não foi encontrada");
    }

    public void deleteById(Long id) {
        LOGGER.info("Deletando a cor");

        iColorRepository.deleteById(id);
    }

    public List<Color> findAll(){
        return iColorRepository.findAll();
    }
}
