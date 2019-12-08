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
import vo.ProdutoVO;

/**
 *
 * @author eitop
 */
public class ProdutoDAO implements CrudDAO {
    
    private Conexao conexao;
    private ProdutoVO produtoVO;
    
    public ProdutoDAO() {
        conexao = new Conexao();
    }
    
    public ProdutoDAO(ProdutoVO produtoVO) {
        conexao = new Conexao();
        this.produtoVO = produtoVO;
    }
    
    @Override
    public void cadastrar() throws SQLException, Exception {
        String sql = "INSERT INTO Produto(Descricao, Categoria, Valor, TempoGarantia)"
                + " VALUES ("
                + produtoVO.getDescricao() + "', '"
                + produtoVO.getCategoria() + "', "
                + produtoVO.getValor() + ", '"
                + produtoVO.getTempoGarantia() + "');";

        System.out.println(sql);

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        sessao.executeUpdate(sql);
        conexao.desconectar();
    }

    @Override
    public ObservableList buscar() throws SQLException, Exception {
        ObservableList<ProdutoVO> produtos = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Produto";

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        ResultSet rs = sessao.executeQuery(sql);

        while (rs.next()) {

            ProdutoVO produtoVO = new ProdutoVO();

            produtoVO.setDescricao(rs.getString("Descricao"));
            produtoVO.setCategoria(rs.getString("Categoria"));
            produtoVO.setValor(rs.getString("Valor"));
            produtoVO.setTempoGarantia(rs.getString("TempoGarantia"));

            produtos.add(produtoVO);
        }

        conexao.desconectar();

        return produtos;
    }
    
    public ProdutoVO buscar(int idProd) throws SQLException, Exception {
        ProdutoVO produtoVO = new ProdutoVO();
        System.out.println("dao.ProdutoDAO.buscar()");

        String sql = "SELECT * FROM Produto where IDProduto = " + idProd + ";";

        System.out.println(sql);

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        ResultSet rs = sessao.executeQuery(sql);

        produtoVO.setDescricao(rs.getString("Descricao"));
        produtoVO.setCategoria(rs.getString("Categoria"));
        produtoVO.setValor(rs.getString("Valor"));
        produtoVO.setTempoGarantia(rs.getString("TempoGarantia"));

        System.out.println(produtoVO.getDescricao());

        conexao.desconectar();

        return produtoVO;
    }
    
    public ProdutoVO buscar(String descricao) throws SQLException, Exception {
        ProdutoVO ConsumidorVO = new ProdutoVO();
        System.out.println("dao.ProdutoDAO.buscar()");

        String sql = "SELECT * FROM Produto where Descricao = '" + descricao + "';";

        System.out.println(sql);

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        ResultSet rs = sessao.executeQuery(sql);

        produtoVO.setDescricao(rs.getString("Descricao"));
        produtoVO.setCategoria(rs.getString("Categoria"));
        produtoVO.setValor(rs.getString("Valor"));
        produtoVO.setTempoGarantia(rs.getString("TempoGarantia"));

        System.out.println(produtoVO.getDescricao());

        conexao.desconectar();

        return produtoVO;
    }

    @Override
    public void editar() throws SQLException, Exception {
        String sql = "UPDATE Produto "
                + "SET Descricao = '" + produtoVO.getDescricao() + "', "
                + "Categoria = '" + produtoVO.getCategoria() + "', "
                + "Valor = " + produtoVO.getValor() + ", "
                + "TempoGarantia = '" + produtoVO.getTempoGarantia() + "' "
                + "WHERE Produto.IDProduto = " + produtoVO.getIdProd() + ";";

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        sessao.executeUpdate(sql);

        conexao.desconectar();
    }

    @Override
    public void excluir() throws SQLException, Exception {
        String sql = "DELETE FROM Produto WHERE Produto.IDProduto = " + produtoVO.getIdProd();

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        sessao.executeUpdate(sql);

        conexao.desconectar();
    }   
}
