package com.br.jireh.jirehconfeccoes.mercadoria.database;

import com.br.jireh.jirehconfeccoes.mercadoria.model.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMercadoriaRepository extends JpaRepository<Mercadoria, Long> {
}
