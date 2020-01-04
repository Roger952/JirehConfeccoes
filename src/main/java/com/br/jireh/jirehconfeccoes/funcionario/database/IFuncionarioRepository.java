package com.br.jireh.jirehconfeccoes.funcionario.database;

import com.br.jireh.jirehconfeccoes.funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
