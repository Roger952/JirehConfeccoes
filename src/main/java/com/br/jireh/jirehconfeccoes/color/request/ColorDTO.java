package com.br.jireh.jirehconfeccoes.color.request;

import com.br.jireh.jirehconfeccoes.color.model.Color;

public class ColorDTO {

    private Long id;
    private String codCor;
    private String nomeCor;

    public ColorDTO() {

    }

    public ColorDTO(Long id, String codCor, String nomeCor) {
        this.id = id;
        this.codCor = codCor;
        this.nomeCor = nomeCor;
    }

    public static ColorDTO of(Color color) {
        return new ColorDTO(
                color.getId(),
                color.getCodCor(),
                color.getNomeCor());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "FornecedorDTO{" +
                "id=" + id +
                ", razaoSocial='" + codCor + '\'' +
                ", cnpj='" + nomeCor + '\'' +
                '}';
    }
}
