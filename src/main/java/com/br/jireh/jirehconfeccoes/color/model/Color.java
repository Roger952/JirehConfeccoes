package com.br.jireh.jirehconfeccoes.color.model;

import com.br.jireh.jirehconfeccoes.imports.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "seg_color")
public class Color extends AbstractEntity {

    @Column(name = "codigo_cor", unique = true, nullable = false, length =  14)
    private String codCor;
    @Column(name = "nome_cor", unique = true, nullable = false, length =  50)
    private String nomeCor;

    public String getCodCor() {
        return codCor;
    }

    public void setCodCor(String codCor) {
        this.codCor = codCor;
    }

    public String getNomeCor() {
        return nomeCor;
    }

    public void setNomeCor(String nomeCor) {
        this.nomeCor = nomeCor;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "razaoSocial='" + codCor + '\'' +
                ", cnpj='" + nomeCor + '\'' +
                '}';
    }
}
