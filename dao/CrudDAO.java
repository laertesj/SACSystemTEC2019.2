/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author eitop
 */

import java.sql.SQLException;
import javafx.collections.ObservableList;

public interface CrudDAO {
    
    public void cadastrar() throws SQLException, Exception;
    
    public ObservableList buscar() throws SQLException, Exception;
    
    public void editar() throws SQLException, Exception;
    
    public void excluir() throws SQLException, Exception;
    
}

