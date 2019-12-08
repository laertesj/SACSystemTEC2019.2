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
import vo.ConsumidorVO;

/**
 *
 * @author eitop
 */
public class ConsumidorDAO implements CrudDAO{
    
    private Conexao conexao;
    private ConsumidorVO consumidorVO;
    
    public ConsumidorDAO() {
        conexao = new Conexao();
    }
    
    public ConsumidorDAO(ConsumidorVO consumidorVO) {
        conexao = new Conexao();
        this.consumidorVO = consumidorVO;
    }

    @Override
    public void cadastrar() throws SQLException, Exception {
          String sql = "INSERT INTO Consumidor(Nome, CPF, Endereco, Telefone, Email)"
                + " VALUES ("
                + consumidorVO.getNome() + "', '"
                + consumidorVO.getCpf() + "', "
                + consumidorVO.getEndereco() + ", '"
                + consumidorVO.getTelefone() + "', '"
                + consumidorVO.getEmail() + "');";

        System.out.println(sql);

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        sessao.executeUpdate(sql);
        conexao.desconectar();
    }

    @Override
    public ObservableList buscar() throws SQLException, Exception {
        ObservableList<ConsumidorVO> consumidores = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Consumidor";

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        ResultSet rs = sessao.executeQuery(sql);

        while (rs.next()) {

            ConsumidorVO consumidorVO = new ConsumidorVO();

            consumidorVO.setNome(rs.getString("nome"));
            consumidorVO.setCpf(rs.getString("cpf"));
            consumidorVO.setEndereco(rs.getString("endereco"));
            consumidorVO.setTelefone(rs.getString("telefone"));
            consumidorVO.setEmail(rs.getString("email"));

            consumidores.add(consumidorVO);
        }

        conexao.desconectar();

        return consumidores;
    }
    
    public ConsumidorVO buscar(int idCons) throws SQLException, Exception {
        ConsumidorVO consumidorVO = new ConsumidorVO();
        System.out.println("dao.ConsumidorDAO.buscar()");

        String sql = "SELECT * FROM Consumidor where IDConsumidor = " + idCons + ";";

        System.out.println(sql);

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        ResultSet rs = sessao.executeQuery(sql);

        consumidorVO.setNome(rs.getString("nome"));
        consumidorVO.setCpf(rs.getString("cpf"));
        consumidorVO.setEndereco(rs.getString("endereco"));
        consumidorVO.setTelefone(rs.getString("telefone"));
        consumidorVO.setEmail(rs.getString("email"));

        System.out.println(consumidorVO.getNome());

        conexao.desconectar();

        return consumidorVO;
    }
    
    public ConsumidorVO buscar(String nome) throws SQLException, Exception {
        ConsumidorVO ConsumidorVO = new ConsumidorVO();
        System.out.println("dao.ConsumidorDAO.buscar()");

        String sql = "SELECT * FROM Consumidor where Nome = '" + nome + "';";

        System.out.println(sql);

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        ResultSet rs = sessao.executeQuery(sql);

        consumidorVO.setNome(rs.getString("nome"));
        consumidorVO.setCpf(rs.getString("cpf"));
        consumidorVO.setEndereco(rs.getString("endereco"));
        consumidorVO.setTelefone(rs.getString("telefone"));
        consumidorVO.setEmail(rs.getString("email"));

        System.out.println(consumidorVO.getNome());

        conexao.desconectar();

        return consumidorVO;
    }

    @Override
    public void editar() throws SQLException, Exception {
        String sql = "UPDATE Consumidor "
                + "SET nome = '" + consumidorVO.getNome() + "', "
                + "cpf = '" + consumidorVO.getCpf() + "', "
                + "endereco = " + consumidorVO.getEndereco() + ", "
                + "telefone = '" + consumidorVO.getTelefone() + "', "
                + "email = '" + consumidorVO.getEmail() + "' "
                + "WHERE Consumidor.IDConsumidor = " + consumidorVO.getIdCons() + ";";

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        sessao.executeUpdate(sql);

        conexao.desconectar();
    }

    @Override
    public void excluir() throws SQLException, Exception {
        String sql = "DELETE FROM Consumidor WHERE Consumidor.IDConsumidor = " + consumidorVO.getIdCons();

        Connection con = conexao.conectar();
        Statement sessao = con.createStatement();

        sessao.executeUpdate(sql);

        conexao.desconectar();
    }   
}
