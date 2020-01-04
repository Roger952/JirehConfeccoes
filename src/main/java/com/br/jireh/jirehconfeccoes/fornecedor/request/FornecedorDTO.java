package com.br.jireh.jirehconfeccoes.fornecedor.request;

import com.br.jireh.jirehconfeccoes.fornecedor.model.Fornecedor;

public class FornecedorDTO {

    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String telefone;
    private String cep;

    public FornecedorDTO(){

    }

    public FornecedorDTO(Long id, String razaoSocial, String cnpj, String email, String telefone, String cep) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
    }

    public static FornecedorDTO of(Fornecedor fornecedor){
        return new FornecedorDTO(
        fornecedor.getId(),
        fornecedor.getRazaoSocial(),
        fornecedor.getCnpj(),
        fornecedor.getEmail(),
        fornecedor.getTelefone(),
        fornecedor.getCep());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "FornecedorDTO{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
