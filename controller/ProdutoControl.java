/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import vo.ProdutoVO;

/**
 *
 * @author eitop
 */
public class ProdutoControl implements CrudControl {
    
    private ProdutoVO produtoVO;

    public ProdutoControl() {
        
    }
    
    public ProdutoControl(ProdutoVO produtoVO) {
        
        this.produtoVO = produtoVO;
    }
    
    public void cadastrar(String descricao, String categoria, String valor, String tempoGarantia) throws SQLException, Exception {
        
        this.ValidarCamposObrigatorios(descricao, categoria, valor, tempoGarantia);
        
        ProdutoVO produtoVO = new ProdutoVO();
        
        produtoVO.setDescricao(descricao);
        produtoVO.setCategoria(categoria);
        produtoVO.setValor(valor);
        produtoVO.setTempoGarantia(tempoGarantia);
        
        ProdutoDAO produtoDAO = new ProdutoDAO(produtoVO);
        produtoDAO.cadastrar();  
    }

    @Override
    public ObservableList buscar() throws SQLException, Exception {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.buscar();
    }
    
    public void editar(String descricao, String categoria, String valor, String tempoGarantia) throws SQLException, Exception {
        
        this.ValidarCamposObrigatorios(descricao, categoria, valor, tempoGarantia);
        
        ProdutoVO produtoVO = new ProdutoVO();
        
        produtoVO.setDescricao(descricao);
        produtoVO.setCategoria(categoria);
        produtoVO.setValor(valor);
        produtoVO.setTempoGarantia(tempoGarantia);
        
        ProdutoDAO produtoDAO = new ProdutoDAO(produtoVO);
        produtoDAO.editar();  
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        ProdutoVO produtoVO = new ProdutoVO();
        produtoVO.setIdProd(id);
        
        ProdutoDAO produtoDao = new ProdutoDAO(produtoVO);
        produtoDao.excluir();
    }
    
    public ProdutoVO buscarProduto(int idProd) throws SQLException, Exception {
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.buscar(idProd);
    }
    
    public ProdutoVO buscarProduto(String descricao) throws SQLException, Exception {
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.buscar(descricao);
    }
    
    private void ValidarCamposObrigatorios(String descricao, String categoria, String valor, String tempoGarantia) throws ValidacaoException {

        if (descricao.isEmpty()) {
            throw new ValidacaoException("Campo Descricao é obrigatório.");
        } else if (categoria.isEmpty()) {
            throw new ValidacaoException("Campo Categoria é obrigatório.");
        } else if (valor.isEmpty()) {
            throw new ValidacaoException("Campo Valor é obrigatório.");
        } else if (tempoGarantia.isEmpty()) {
            throw new ValidacaoException("Campo Tempo de Garantia é obrigatório.");
        }
    }
    
}
