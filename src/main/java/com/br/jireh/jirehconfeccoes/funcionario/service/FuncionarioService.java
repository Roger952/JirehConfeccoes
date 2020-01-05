package com.br.jireh.jirehconfeccoes.funcionario.service;

import com.br.jireh.jirehconfeccoes.funcionario.database.IFuncionarioRepository;
import com.br.jireh.jirehconfeccoes.funcionario.model.Funcionario;
import com.br.jireh.jirehconfeccoes.funcionario.request.FuncionarioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {
    private static Logger LOGGER = LoggerFactory.getLogger(FuncionarioService.class);

    private final IFuncionarioRepository iFuncionarioRepository;

    public FuncionarioService(IFuncionarioRepository iFuncionarioRepository) {
        this.iFuncionarioRepository = iFuncionarioRepository;
    }

    private static void validate(FuncionarioDTO funcionarioDTO) {

        LOGGER.info("Validando os produtos");

        if (funcionarioDTO.getNome().isEmpty()) {
            throw new IllegalArgumentException("Informe a nome do funcionario");
        }
        if (funcionarioDTO.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("Informe o telefone do funcionario");
        }
        if (funcionarioDTO.getCpf().isEmpty()) {
            throw new IllegalArgumentException("Informe o cpf do funcionario");
        }
        if (funcionarioDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Informe o email do funcionario");
        }
        if (funcionarioDTO.getCep().isEmpty()) {
            throw new IllegalArgumentException("Informe o cep do funcionario");
        }
        if (funcionarioDTO.getFuncao().isEmpty()){
            throw new IllegalArgumentException("Informe a funcao do funcionario");
        }
    }

    public FuncionarioDTO save(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();

        LOGGER.info("Salvando o funcioanario");

        validate(funcionarioDTO);

        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setCep(funcionarioDTO.getCep());
        funcionario.setFuncao(funcionarioDTO.getFuncao());

        funcionario = iFuncionarioRepository.save(funcionario);

        return FuncionarioDTO.of(funcionario);
    }

    public FuncionarioDTO update(FuncionarioDTO funcionarioDTO, Long id) {

        Optional<Funcionario> optionalFornecedor = iFuncionarioRepository.findById(id);

        validate(funcionarioDTO);

        Funcionario funcionario;
        if (optionalFornecedor.isPresent()) {
            funcionario = optionalFornecedor.get();

            LOGGER.info("Atualizando o funcioanario");

            funcionario.setNome(funcionarioDTO.getNome());
            funcionario.setCpf(funcionarioDTO.getCpf());
            funcionario.setEmail(funcionarioDTO.getEmail());
            funcionario.setTelefone(funcionarioDTO.getTelefone());
            funcionario.setCep(funcionarioDTO.getCep());
            funcionario.setFuncao(funcionarioDTO.getFuncao());

            funcionario = iFuncionarioRepository.save(funcionario);

            return FuncionarioDTO.of(funcionario);
        }

        throw new IllegalArgumentException("Este fornecedor não foi encontrado");
    }

    public void deleteById(Long id){
        LOGGER.info("Deletando o funcioanario");

        iFuncionarioRepository.deleteById(id);
    }
}
