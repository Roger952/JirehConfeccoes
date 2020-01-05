package com.br.jireh.jirehconfeccoes.mercadoria.service;

import com.br.jireh.jirehconfeccoes.fornecedor.service.FornecedorService;
import com.br.jireh.jirehconfeccoes.mercadoria.database.IMercadoriaRepository;
import com.br.jireh.jirehconfeccoes.mercadoria.model.Mercadoria;
import com.br.jireh.jirehconfeccoes.mercadoria.request.MercadoriaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MercadoriaService {
    private static Logger LOGGER = LoggerFactory.getLogger(MercadoriaService.class);

    private final IMercadoriaRepository iMercadoriaRepository;
    private final FornecedorService fornecedorService;

    public MercadoriaService(IMercadoriaRepository iMercadoriaRepository, FornecedorService fornecedorService) {
        this.iMercadoriaRepository = iMercadoriaRepository;
        this.fornecedorService = fornecedorService;
    }

    private static void validate(MercadoriaDTO mercadoriaDTO) {

        LOGGER.info("Validando a mercadoria");

        if (mercadoriaDTO.getDescricaoMercadoria().isEmpty()) {
            throw new IllegalArgumentException("Informe a descrição para esta mercadoria");
        } else if (mercadoriaDTO.getDescricaoMercadoria().length() > 100) {
            throw new IllegalArgumentException("A descriçãço não deve conter mais de 100 caracteres");
        }
        if (mercadoriaDTO.getValorPeca() <= 0) {
            throw new IllegalArgumentException("O valor é inválido");
        }
        if (mercadoriaDTO.getOp().isEmpty()) {
            throw new IllegalArgumentException("Informe a op da mercadoria");
        } else if (mercadoriaDTO.getOp().length() > 50) {
            throw new IllegalArgumentException("A qunatidade não pode ter mais de 50 caracteres");
        }
        if (mercadoriaDTO.getReferencia().isEmpty()) {
            throw new IllegalArgumentException("Informe a referencia da mercadoria");
        } else if (mercadoriaDTO.getReferencia().length() > 50) {
            throw new IllegalArgumentException("A referencia nao deve conter mais de 50 caracteres");
        }
        if (mercadoriaDTO.getQuantidadeTotal() <= 0) {
            throw new IllegalArgumentException("A quntitidade inserida é inválida");
        }
        if (String.valueOf(mercadoriaDTO.getIdFornecedor()).isEmpty()) {
            throw new IllegalArgumentException("Informe o id do mercadoria");
        }
    }

    public MercadoriaDTO save(MercadoriaDTO mercadoriaDTO) {
        Mercadoria mercadoria = new Mercadoria();

        LOGGER.info("Salvando o mercadoria");

        validate(mercadoriaDTO);

        mercadoria.setDescricaoMercadoria(mercadoriaDTO.getDescricaoMercadoria());
        mercadoria.setOp(mercadoriaDTO.getOp());
        mercadoria.setReferencia(mercadoriaDTO.getReferencia());
        mercadoria.setValorPeca(mercadoriaDTO.getValorPeca());
        mercadoria.setQuantidadeTotal(mercadoriaDTO.getQuantidadeTotal());
        mercadoria.setFornecedor(fornecedorService.findById(mercadoriaDTO.getIdFornecedor()));

        mercadoria = iMercadoriaRepository.save(mercadoria);

        return MercadoriaDTO.of(mercadoria);
    }

    public MercadoriaDTO update(MercadoriaDTO mercadoriaDTO, Long id) {

        Optional<Mercadoria> optionalMercadoria = iMercadoriaRepository.findById(id);

        validate(mercadoriaDTO);

        Mercadoria mercadoria;
        if (optionalMercadoria.isPresent()) {
            mercadoria = optionalMercadoria.get();

            LOGGER.info("Atualizando o mercadoria");

            mercadoria.setDescricaoMercadoria(mercadoriaDTO.getDescricaoMercadoria());
            mercadoria.setOp(mercadoriaDTO.getOp());
            mercadoria.setReferencia(mercadoriaDTO.getReferencia());
            mercadoria.setValorPeca(mercadoriaDTO.getValorPeca());
            mercadoria.setQuantidadeTotal(mercadoriaDTO.getQuantidadeTotal());
            mercadoria.setFornecedor(fornecedorService.findById(mercadoriaDTO.getIdFornecedor()));

            mercadoria = iMercadoriaRepository.save(mercadoria);

            return MercadoriaDTO.of(mercadoria);
        }

        throw new IllegalArgumentException("Este mercadoria não foi encontrado");
    }

    public void deleteById(Long id) {
        LOGGER.info("Deletando o mercadoria");

        iMercadoriaRepository.deleteById(id);
    }
}
