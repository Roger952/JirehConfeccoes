package com.br.jireh.jirehconfeccoes.fornecedor.model;

import com.br.jireh.jirehconfeccoes.imports.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "seg_fornecdores")
public class Fornecedor extends AbstractEntity {

    @Column(name = "razao_social", unique = true, nullable = false, length =  50)
    private String razaoSocial;
    @Column(name = "cpnj", unique = true, nullable = false, length =  14)
    private String cnpj;
    @Column(name = "email", unique = true, nullable = false, length =  65)
    private String email;
    @Column(name = "telefone", unique = true, nullable = false, length =  14)
    private String telefone;
    @Column(name = "cep", unique = true, nullable = false, length =  15)
    private String cep;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
