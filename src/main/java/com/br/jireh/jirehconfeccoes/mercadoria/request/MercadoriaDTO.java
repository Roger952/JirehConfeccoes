package com.br.jireh.jirehconfeccoes.mercadoria.request;

import com.br.jireh.jirehconfeccoes.mercadoria.model.Mercadoria;

public class MercadoriaDTO {

    private Long id;
    private String descricaoMercadoria;
    private String op;
    private String referencia;
    private Double valorPeca;
    private Integer quantidadeTotal;
    private Long idFornecedor;

    public MercadoriaDTO() {

    }

    public MercadoriaDTO(Long id, String descricaoMercadoria, String op, String referencia, Double valorPeca, Integer quantidadeTotal, Long idFornecedor) {
        this.id = id;
        this.descricaoMercadoria = descricaoMercadoria;
        this.op = op;
        this.referencia = referencia;
        this.valorPeca = valorPeca;
        this.quantidadeTotal = quantidadeTotal;
        this.idFornecedor = idFornecedor;
    }

    public static MercadoriaDTO of(Mercadoria mercadoria) {
        return new MercadoriaDTO(
                mercadoria.getId(),
                mercadoria.getDescricaoMercadoria(),
                mercadoria.getOp(),
                mercadoria.getReferencia(),
                mercadoria.getValorPeca(),
                mercadoria.getQuantidadeTotal(),
                mercadoria.getFornecedor().getId()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoMercadoria() {
        return descricaoMercadoria;
    }

    public void setDescricaoMercadoria(String descricaoMercadoria) {
        this.descricaoMercadoria = descricaoMercadoria;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(Double valorPeca) {
        this.valorPeca = valorPeca;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @Override
    public String toString() {
        return "MercadoriaDTO{" +
                "id=" + id +
                ", descricaoMercadoria='" + descricaoMercadoria + '\'' +
                ", op='" + op + '\'' +
                ", referencia='" + referencia + '\'' +
                ", valorPeca=" + valorPeca +
                ", quantidadeTotal=" + quantidadeTotal +
                ", idFornecedor=" + idFornecedor +
                '}';
    }
}
