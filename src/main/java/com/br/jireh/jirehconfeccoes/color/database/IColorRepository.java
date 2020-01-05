package com.br.jireh.jirehconfeccoes.color.database;

import com.br.jireh.jirehconfeccoes.color.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColorRepository extends JpaRepository<Color, Long> {
    Boolean existsByCodCor(String codCor);
    Boolean existsByNomeCor(String nomeCor);
}
