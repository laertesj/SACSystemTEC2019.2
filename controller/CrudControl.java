/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author eitop
 */
import java.sql.SQLException;
import javafx.collections.ObservableList;

public interface CrudControl {
    
    public ObservableList buscar() throws SQLException, Exception;
    
    public void excluir(int id) throws SQLException, Exception;
}
