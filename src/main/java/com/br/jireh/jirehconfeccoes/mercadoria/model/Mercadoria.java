package com.br.jireh.jirehconfeccoes.mercadoria.model;

import com.br.jireh.jirehconfeccoes.fornecedor.model.Fornecedor;
import com.br.jireh.jirehconfeccoes.imports.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "seg_mercadoria")
public class Mercadoria extends AbstractEntity {

    @Column(name = "descricao_mercadoria", nullable = false, length =  100)
    private String descricaoMercadoria;
    @Column(name = "Op", unique = true, nullable = false, length =  50)
    private String op;
    @Column(name = "referencia", unique = true, nullable = false, length =  50)
    private String referencia;
    @Column(name = "valor_peca", nullable = false)
    private Double valorPeca;
    @Column(name = "quantidade_total", nullable = false)
    private Integer quantidadeTotal;
    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Mercadoria{" +
                "descricaoMercadoria='" + descricaoMercadoria + '\'' +
                ", op='" + op + '\'' +
                ", referencia='" + referencia + '\'' +
                ", valorPeca=" + valorPeca +
                ", quantidadeTotal=" + quantidadeTotal +
                ", fornecedor=" + fornecedor +
                '}';
    }
}
