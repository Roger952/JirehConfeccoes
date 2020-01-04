package com.br.jireh.jirehconfeccoes.funcionario.model;

import com.br.jireh.jirehconfeccoes.imports.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "seg_funcionario")
public class Funcionario extends AbstractEntity {

    @Column(name = "nome", nullable = false, length =  75)
    private String nome;
    @Column(name = "cpf", unique = true, nullable = false, length =  14)
    private String cpf;
    @Column(name = "email", unique = true, nullable = false, length =  65)
    private String email;
    @Column(name = "telefone", unique = true, nullable = false, length =  14)
    private String telefone;
    @Column(name = "cep", unique = true, nullable = false, length =  15)
    private String cep;
    @Column(name = "funcao", nullable = false)
    private String funcao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}
