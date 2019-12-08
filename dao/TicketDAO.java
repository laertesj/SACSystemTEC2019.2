/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vo.TicketVO;

/**
 *
 * @author eitop
 */
public class TicketDAO implements CrudDAO {
    
    private Conexao conexao;
    private TicketVO ticketVO;
    
    public TicketDAO() {
        conexao = new Conexao();
    }
    
    public TicketDAO(TicketVO ticketVO) {
        conexao = new Conexao();
        this.ticketVO = ticketVO;
    }

    @Override
    public void cadastrar() throws SQLException, Exception {
        String sql = "INSERT INTO Ticket(Descricao, Categoria, Prazo, DataAbertura"
                + "DataEncerramento, Pedido, DataCompra, StatusGarantia, FuncionarioResponsavel, IDConsumidor, IDProduto)"
                + " VALUES ("
                + ticketVO.getDescricao() + "', '"
                + ticketVO.getCategoria() + "', "
                + ticketVO.getPrazo() + "', "
                + ticketVO.getDataAbertura() + "', "
                + ticketVO.getDataEncerramento() + "', "
                + ticketVO.getPedido() + "', "
                + ticketVO.getDataCompra() + "', "
                + ticketVO.getStatusGarantia() + "', "
                + ticketVO.getFuncionarioResponsavel() + "', "
                + ticketVO.getIdCons() + "', "
                + ticketVO.getIdProd() + "');";

        System.out.println(sql);

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        sessao.executeUpdate(sql);
        conexao.desconectar();
    }

    @Override
    public ObservableList buscar() throws SQLException, Exception {
        ObservableList<TicketVO> tickets = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Ticket";

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        ResultSet rs = sessao.executeQuery(sql);

        while (rs.next()) {

            TicketVO ticketVO = new TicketVO();

            ticketVO.setDescricao(rs.getString("Descricao"));
            ticketVO.setCategoria(rs.getString("Categoria"));
            ticketVO.setPrazo(rs.getString("Prazo"));
            ticketVO.setDataAbertura(rs.getString("DataAbertura"));
            ticketVO.setDataEncerramento(rs.getString("DataEncerramento"));
            ticketVO.setPedido(rs.getString("Pedido"));
            ticketVO.setDataCompra(rs.getString("DataCompra"));
            ticketVO.setStatusGarantia(rs.getString("StatusGarantia"));
            ticketVO.setFuncionarioResponsavel(rs.getString("FuncionarioResponsavel"));
            ticketVO.setIdCons(rs.getInt("IDConsumidor"));
            ticketVO.setIdProd(rs.getInt("IDProduto"));

            tickets.add(ticketVO);
        }

        conexao.desconectar();

        return tickets;
    }
    
    public TicketVO buscar(int idTicket) throws SQLException, Exception {
        TicketVO ticketVO = new TicketVO();
        System.out.println("dao.TicketDAO.buscar()");

        String sql = "SELECT * FROM Ticket where IDTicket = " + idTicket + ";";

        System.out.println(sql);

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        ResultSet rs = sessao.executeQuery(sql);
        
        ticketVO.setDescricao(rs.getString("Descricao"));
        ticketVO.setCategoria(rs.getString("Categoria"));
        ticketVO.setPrazo(rs.getString("Prazo"));
        ticketVO.setDataAbertura(rs.getString("DataAbertura"));
        ticketVO.setDataEncerramento(rs.getString("DataEncerramento"));
        ticketVO.setPedido(rs.getString("Pedido"));
        ticketVO.setDataCompra(rs.getString("DataCompra"));
        ticketVO.setStatusGarantia(rs.getString("StatusGarantia"));
        ticketVO.setFuncionarioResponsavel(rs.getString("FuncionarioResponsavel"));
        ticketVO.setIdCons(rs.getInt("IDConsumidor"));
        ticketVO.setIdProd(rs.getInt("IDProduto"));

        System.out.println(ticketVO.getDescricao());

        conexao.desconectar();

        return ticketVO;
    }

    @Override
    public void editar() throws SQLException, Exception {
        String sql = "UPDATE Ticket "
                + "SET Descricao = '" + ticketVO.getDescricao() + "', "
                + "Categoria = '" + ticketVO.getCategoria() + "', "
                + "Prazo = " + ticketVO.getPrazo() + ", "
                + "DataAbertura = " + ticketVO.getDataAbertura() + ", "
                + "DataEncerramento = " + ticketVO.getPrazo() + ", "
                + "Pedido = " + ticketVO.getPrazo() + ", "
                + "DataCompra = " + ticketVO.getPrazo() + ", "
                + "StatusGarantia = '" + ticketVO.getStatusGarantia() + "' "
                + "FuncionarioResponsavel = " + ticketVO.getPrazo() + ", "
                + "IDConsumidor = " + ticketVO.getIdCons() + ", "
                + "IDProduto = " + ticketVO.getIdProd() + ", "
                + "WHERE Ticket.IDTicket = " + ticketVO.getIdTicket() + ";";

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        sessao.executeUpdate(sql);

        conexao.desconectar();
    }

    @Override
    public void excluir() throws SQLException, Exception {
        String sql = "DELETE FROM Ticket WHERE Ticket.IDTicket = " + ticketVO.getIdTicket();

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        sessao.executeUpdate(sql);

        conexao.desconectar();
    }
    
}
