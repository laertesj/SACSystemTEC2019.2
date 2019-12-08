/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author eitop
 */
public class TelaTeste1 extends Application {

    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {
        Conexao conexao = new Conexao();

        Connection con;
        
        con = conexao.conectar();
        Statement sessao = con.createStatement();
}

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
        launch(args);
    }
    
}
