/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TicketDAO;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import vo.TicketVO;

/**
 *
 * @author eitop
 */
public class TicketControl implements CrudControl {
    
    private TicketVO ticketVO;

    public TicketControl() {
        
    }
    
    public TicketControl(TicketVO ticketVO) {
        
        this.ticketVO = ticketVO;
    }
    
    public void cadastrar(String descricao, String categoria, String prazo, String dataAbertura, String dataEncerramento,
            String pedido, String dataCompra, String statusGarantia, String funcionarioResponsavel,
            int idCons, int idProd) throws ValidacaoException, SQLException, NullPointerException, Exception {
        
        this.ValidarCamposObrigatorios(descricao, categoria, prazo, dataAbertura, dataEncerramento, pedido, dataCompra,
                statusGarantia, funcionarioResponsavel, idCons, idProd);
        
        TicketVO ticketVO = new TicketVO();
        
        ticketVO.setDescricao(descricao);
        ticketVO.setCategoria(categoria);
        ticketVO.setPrazo(prazo);
        ticketVO.setDataAbertura(dataAbertura);
        ticketVO.setDataEncerramento(dataEncerramento);
        ticketVO.setPedido(pedido);
        ticketVO.setDataCompra(dataCompra);
        ticketVO.setStatusGarantia(statusGarantia);
        ticketVO.setFuncionarioResponsavel(funcionarioResponsavel);
        ticketVO.setIdCons(idCons);
        ticketVO.setIdProd(idProd);
        
        TicketDAO ticketDAO = new TicketDAO(ticketVO);
        ticketDAO.cadastrar();  
    }
    
    @Override
    public ObservableList buscar() throws SQLException, Exception {
        TicketDAO ticketDAO = new TicketDAO();
        return ticketDAO.buscar();
    }
    
    public TicketVO buscar(int idTicket) throws SQLException, Exception {
        
        TicketDAO ticketDAO = new TicketDAO();
        return ticketDAO.buscar(idTicket);
    }
    
    public void editar(String descricao, String categoria, String prazo, String dataAbertura, String dataEncerramento,
            String pedido, String dataCompra, String statusGarantia, String funcionarioResponsavel,
            int idCons, int idProd) throws ValidacaoException, SQLException, NullPointerException, Exception {
        
        this.ValidarCamposObrigatorios(descricao, categoria, prazo, dataAbertura, dataEncerramento, pedido, dataCompra,
                statusGarantia, funcionarioResponsavel, idCons, idProd);
        
        TicketVO ticketVO = new TicketVO();
        
        ticketVO.setDescricao(descricao);
        ticketVO.setCategoria(categoria);
        ticketVO.setPrazo(prazo);
        ticketVO.setDataAbertura(dataAbertura);
        ticketVO.setDataEncerramento(dataEncerramento);
        ticketVO.setPedido(pedido);
        ticketVO.setDataCompra(dataCompra);
        ticketVO.setStatusGarantia(statusGarantia);
        ticketVO.setFuncionarioResponsavel(funcionarioResponsavel);
        ticketVO.setIdCons(idCons);
        ticketVO.setIdProd(idProd);
        
        TicketDAO ticketDAO = new TicketDAO(ticketVO);
        ticketDAO.editar(); 
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        TicketVO ticketVO = new TicketVO();
        ticketVO.setIdTicket(id);
        
        TicketDAO ticketDao = new TicketDAO(ticketVO);
        ticketDao.excluir();
    }
    
    private void ValidarCamposObrigatorios(String descricao, String categoria, String prazo, String dataAbertura, String dataEncerramento,
            String pedido, String dataCompra, String statusGarantia, String funcionarioResponsavel,
            int idCons, int idProd) throws ValidacaoException {

        if (descricao.isEmpty()) {
            throw new ValidacaoException("Campo Descricao é obrigatório.");
        } else if (categoria.isEmpty()) {
            throw new ValidacaoException("Campo Categoria é obrigatório.");
        } else if (prazo.isEmpty()) {
            throw new ValidacaoException("Campo Prazo é obrigatório.");
        } else if (dataAbertura.isEmpty()) {
            throw new ValidacaoException("Campo Data de Abertura é obrigatório.");
        } else if (dataEncerramento.isEmpty()) {
            throw new ValidacaoException("Campo Data de Encerramento é obrigatório.");
        } else if (pedido.isEmpty()) {
            throw new ValidacaoException("Campo Data de Pedido é obrigatório.");
        } else if (dataCompra.isEmpty()) {
            throw new ValidacaoException("Campo Data de Compra é obrigatório.");
        } else if (statusGarantia.isEmpty()) {
            throw new ValidacaoException("Campo Status da Garantia é obrigatório.");
        } else if (funcionarioResponsavel.isEmpty()) {
            throw new ValidacaoException("Campo Funcionário Responsável é obrigatório.");
        } else if (idCons <= 0) {
            throw new ValidacaoException("É necessário informar o ID do Consumidor.");
        } else {
            try {
            } catch (NumberFormatException e) {
                throw new ValidacaoException("Campo RA deve conter apenas números");
            }
        } if (idProd <= 0) {
            throw new ValidacaoException("É necessário informar o ID do Produto.");
        } else {
            try {
            } catch (NumberFormatException e) {
                throw new ValidacaoException("Campo RA deve conter apenas números");
            }
        }
    }
}
