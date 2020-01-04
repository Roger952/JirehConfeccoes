package com.br.jireh.jirehconfeccoes.funcionario.request;

import com.br.jireh.jirehconfeccoes.funcionario.model.Funcionario;

public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String cep;
    private String funcao;


    public FuncionarioDTO(){

    }

    public FuncionarioDTO(Long id, String nome, String cpf, String email, String telefone, String cep, String funcao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.funcao = funcao;
    }

    public static FuncionarioDTO of(Funcionario funcionario){
        return new FuncionarioDTO(
            funcionario.getId(),
            funcionario.getNome(),
            funcionario.getCpf(),
            funcionario.getEmail(),
            funcionario.getTelefone(),
            funcionario.getCep(),
                funcionario.getFuncao()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "FuncionarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}
