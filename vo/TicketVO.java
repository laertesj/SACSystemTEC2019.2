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
public class TicketVO {
    
    int idTicket;
    int idCons;
    int idProd;
    String descricao;
    String categoria;
    String prazo;
    String dataAbertura;
    String dataEncerramento;
    String pedido;
    String dataCompra;
    String statusGarantia;
    String funcionarioResponsavel;
    
    public TicketVO() {
        
    }
    
    public TicketVO(int idCons, int idProd, String descricao, String categoria, String prazo,
            String dataAbertura, String dataEncerramento, String pedido, String dataCompra, String statusGarantia,
            String funcionarioResponsavel) {
        this.idCons = idCons;
        this.idProd = idProd;
        this.descricao = descricao;
        this.categoria = categoria;
        this.prazo = prazo;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        this.pedido = pedido;
        this.dataCompra = dataCompra;
        this.statusGarantia = statusGarantia;
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }
    
    public int getIdCons() {
        return idCons;
    }

    public void setIdCons(int idCons) {
        this.idCons = idCons;
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

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getStatusGarantia() {
        return statusGarantia;
    }

    public void setStatusGarantia(String statusGarantia) {
        this.statusGarantia = statusGarantia;
    }

    public String getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(String funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }
}