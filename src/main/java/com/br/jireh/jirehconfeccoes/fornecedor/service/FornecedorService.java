package com.br.jireh.jirehconfeccoes.fornecedor.service;

import com.br.jireh.jirehconfeccoes.fornecedor.database.IFornecedorRepository;
import com.br.jireh.jirehconfeccoes.fornecedor.model.Fornecedor;
import com.br.jireh.jirehconfeccoes.fornecedor.request.FornecedorDTO;
import com.br.jireh.jirehconfeccoes.validations.CNPJValidation;
import com.br.jireh.jirehconfeccoes.validations.EmailValidation;
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

    private void validate(FornecedorDTO fornecedorDTO) {

        LOGGER.info("Validando os produtos");

        if (fornecedorDTO.getRazaoSocial().isEmpty()) {
            throw new IllegalArgumentException("Informe a razao do fornecedor");
        }else if (iFornecedorRepository.existsByRazaoSocial(fornecedorDTO.getRazaoSocial())){
            throw new IllegalArgumentException("Já existe esta razão social");
        }
        if (fornecedorDTO.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("Informe o telefone do fornecedor");
        } else if (fornecedorDTO.getTelefone().length() > 14) {
            throw new IllegalArgumentException("O telefone nao deve conter mais de 14 caracteres");
        }
        if (fornecedorDTO.getCnpj().isEmpty()) {
            throw new IllegalArgumentException("Informe o cnpj do fornecedor");
        } else if (iFornecedorRepository.existsByCnpj(fornecedorDTO.getCnpj())){
            throw new IllegalArgumentException("Já existe este cnpj");
        } else if (fornecedorDTO.getCnpj().length() > 14) {
            throw new IllegalArgumentException("O cnpj nao deve conter mais de 14 caracteres");
        } else if (CNPJValidation.isCNPJ(fornecedorDTO.getCnpj())) {
            throw new IllegalArgumentException("Cnpj nao inválido");
        }
        if (fornecedorDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Informe o email do fornecedor");
        } else if (fornecedorDTO.getEmail().length() > 50) {
            throw new IllegalArgumentException("O email nao deve conter mais de 50 caracteres");
        } else if (EmailValidation.isValidEmailAddressRegex(fornecedorDTO.getEmail())) {
            throw new IllegalArgumentException("Email nao inválido");
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

    public void deleteById(Long id) {
        LOGGER.info("Deletando o fornecedor");

        iFornecedorRepository.deleteById(id);
    }

    public Fornecedor findById(Long id){
        Optional<Fornecedor> optionalFornecedor = iFornecedorRepository.findById(id);

        if (optionalFornecedor.isPresent()){
            return optionalFornecedor.get();
        }

        throw new IllegalArgumentException("Nao existe um fornecedor com este Id");
    }
}
