package com.br.jireh.jirehconfeccoes.fornecedor.service;

import com.br.jireh.jirehconfeccoes.fornecedor.database.IFornecedorRepository;
import com.br.jireh.jirehconfeccoes.fornecedor.model.Fornecedor;
import com.br.jireh.jirehconfeccoes.fornecedor.request.FornecedorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorService {
    private static Logger LOGGER = LoggerFactory.getLogger(FornecedorService.class);

    private final IFornecedorRepository iFornecedorRepository;

    public FornecedorService(IFornecedorRepository iFornecedorRepository) {
        this.iFornecedorRepository = iFornecedorRepository;
    }

    private static void validate(FornecedorDTO fornecedorDTO) {

        LOGGER.info("Validando os produtos");

        if (fornecedorDTO.getRazaoSocial().isEmpty()) {
            throw new IllegalArgumentException("Informe a razao do fornecedor");
        }
        if (fornecedorDTO.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("Informe o telefone do fornecedor");
        }
        if (fornecedorDTO.getCnpj().isEmpty()) {
            throw new IllegalArgumentException("Informe o cnpj do fornecedor");
        }
        if (fornecedorDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Informe o email do fornecedor");
        }
        if (fornecedorDTO.getCep().isEmpty()) {
            throw new IllegalArgumentException("Informe o cep do fornecedor");
        }
    }

    public FornecedorDTO save(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();

        LOGGER.info("Salvando o fornecedor");

        validate(fornecedorDTO);

        fornecedor.setRazaoSocial(fornecedorDTO.getRazaoSocial());
        fornecedor.setCnpj(fornecedorDTO.getCnpj());
        fornecedor.setEmail(fornecedorDTO.getEmail());
        fornecedor.setTelefone(fornecedorDTO.getEmail());
        fornecedor.setCep(fornecedorDTO.getCep());

        fornecedor = iFornecedorRepository.save(fornecedor);

        return FornecedorDTO.of(fornecedor);
    }

    public FornecedorDTO update(FornecedorDTO fornecedorDTO, Long id) {

        Optional<Fornecedor> optionalFornecedor = iFornecedorRepository.findById(id);

        validate(fornecedorDTO);

        Fornecedor fornecedor;
        if (optionalFornecedor.isPresent()) {
            fornecedor = optionalFornecedor.get();

            LOGGER.info("Atualizando o fornecedor");

            fornecedor.setRazaoSocial(fornecedorDTO.getRazaoSocial());
            fornecedor.setCnpj(fornecedorDTO.getCnpj());
            fornecedor.setEmail(fornecedorDTO.getEmail());
            fornecedor.setTelefone(fornecedorDTO.getTelefone());
            fornecedor.setCep(fornecedorDTO.getCep());

            fornecedor = iFornecedorRepository.save(fornecedor);

            return FornecedorDTO.of(fornecedor);
        }

        throw new IllegalArgumentException("Este fornecedor não foi encontrado");
    }
}
