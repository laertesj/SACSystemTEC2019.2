package dao;

/**
 *
 * @author Laertes
 */

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {

    private static Connection con;
    private final String driver;

    public Conexao() {
        driver = "org.sqlite.JDBC";
    }

    public Connection conectar() throws ClassNotFoundException, SQLException {
        con = null;

        File file = new File("GestaoReclamacoes.db");
        Class.forName(driver);
        if (file.exists()) {
            System.out.println("Arquivo já existe.");
            con = DriverManager.getConnection("jdbc:sqlite:GestaoReclamacoes.db");
            JOptionPane.showMessageDialog(null, "Conexão Estabelecida.");
        } else {
            con = DriverManager.getConnection("jdbc:sqlite:GestaoReclamacoes.db");
            JOptionPane.showMessageDialog(null, "Conexão Estabelecida.");
            //criarTabela();
        }
        return con;
    }

    public void criarTabela() throws SQLException {

        String sql = "CREATE TABLE Consumidor ("
                + "	IDConsumidor integer PRIMARY KEY AUTOINCREMENT,"
                + "	Nome string,"
                + "	CPF string,"
                + "	Endereço string,"
                + "	Telefone string,"
                + "	Email string,"
                + ");"
                + "CREATE TABLE Produto ("
                + "	IDProduto integer PRIMARY KEY AUTOINCREMENT,"
                + "	Descricao string,"
                + "	Categoria string,"
                + "	Valor string,"
                + "	TempoGarantia string,"
                + ");"
                + "CREATE TABLE Ticket ("
                + "	IDTicket integer PRIMARY KEY AUTOINCREMENT,"
                + "	Descricao string,"
                + "	Categoria string,"
                + "	Prazo string,"
                + "	DataAbertura string,"
                + "	DataEncerramento string,"
                + "	Pedido string,"
                + "	DataCompra string"
                + "	StatusGarantia string,"
                + "	FuncionarioResponsavel string,"
                + "	IDConsumidor integer,"
                + "	IDProduto integer,"
                + "	FOREIGN KEY(IDConsumidor) REFERENCES Consumidor(IDConsumidor)"
                + "         ON UPDATE SET NO ACTION"
                + "         ON DELETE SET NO ACTION"
                + "	FOREIGN KEY(IDProduto) REFERENCES Produto(IDProduto)"
                + "         ON UPDATE SET NO ACTION"
                + "         ON DELETE SET NO ACTION"
                + ");";

        Statement sessao = con.createStatement();
        sessao.executeUpdate(sql);
    }

    public void desconectar() throws SQLException {

        con.close();
    }
}
