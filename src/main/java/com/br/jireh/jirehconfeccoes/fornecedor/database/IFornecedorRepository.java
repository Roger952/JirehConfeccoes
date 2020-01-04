package com.br.jireh.jirehconfeccoes.fornecedor.database;

import com.br.jireh.jirehconfeccoes.fornecedor.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
