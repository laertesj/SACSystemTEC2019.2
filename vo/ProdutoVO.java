/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author eitop
 */
public class ProdutoVO {
    
    private int idProd;
    private String descricao;
    private String categoria;
    private String valor;
    private String tempoGarantia;
    
    public ProdutoVO() {
    
    }
    
    public ProdutoVO(String descricao, String categoria, String valor, String tempoGarantia) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.tempoGarantia = tempoGarantia;
    }
    
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTempoGarantia() {
        return tempoGarantia;
    }

    public void setTempoGarantia(String tempoGarantia) {
        this.tempoGarantia = tempoGarantia;
    }
}
