/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConsumidorDAO;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import vo.ConsumidorVO;

/**
 *
 * @author eitop
 */
public class ConsumidorControl implements CrudControl {
    private ConsumidorVO consumidorVO;

    public ConsumidorControl() {

    }

    public ConsumidorControl(ConsumidorVO consumidorVO) {

        this.consumidorVO = consumidorVO;
    }
    
    public void cadastrar(String nome, String cpf, String endereco, String telefone, String email) throws ValidacaoException, SQLException, NullPointerException, Exception {
        
        this.ValidarCamposObrigatorios(nome, cpf, endereco, telefone, email);
        
        ConsumidorVO consumidorVo = new ConsumidorVO();

        consumidorVo.setNome(nome);
        consumidorVo.setCpf(cpf);
        consumidorVo.setEndereco(endereco);
        consumidorVo.setTelefone(telefone);
        consumidorVo.setEmail(email);

        ConsumidorDAO consumidorDAO = new ConsumidorDAO(consumidorVo);
        consumidorDAO.cadastrar();
    }

    @Override
    public ObservableList buscar() throws SQLException, Exception {
        
        ConsumidorDAO consumidorDAO = new ConsumidorDAO();
        return consumidorDAO.buscar();
    }
    
    public ConsumidorVO buscar(int idCons) throws SQLException, Exception {
        ConsumidorDAO consumidorDAO = new ConsumidorDAO();
        return consumidorDAO.buscar(idCons);
    }
    
    public void editar(String nome, String cpf, String endereco, String telefone, String email) throws ValidacaoException, SQLException, NullPointerException, Exception {
        
        this.ValidarCamposObrigatorios(nome, cpf, endereco, telefone, email);
        
        ConsumidorVO consumidorVo = new ConsumidorVO();

        consumidorVo.setNome(nome);
        consumidorVo.setCpf(cpf);
        consumidorVo.setEndereco(endereco);
        consumidorVo.setTelefone(telefone);
        consumidorVo.setEmail(email);

        ConsumidorDAO consumidorDAO = new ConsumidorDAO(consumidorVo);
        consumidorDAO.cadastrar();
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        ConsumidorVO consumidorVO = new ConsumidorVO();
        consumidorVO.setIdCons(id);
        
        ConsumidorDAO consumidorDao = new ConsumidorDAO(consumidorVO);
        consumidorDao.excluir();
    }
    
    public ConsumidorVO buscar(String nome) throws SQLException, Exception {
        ConsumidorDAO consumidorDao = new ConsumidorDAO();
        return consumidorDao.buscar(nome);
    }
    
    private void ValidarCamposObrigatorios(String nome, String cpf, String endereco, String telefone, String email) throws ValidacaoException {

        if (nome.isEmpty()) {
            throw new ValidacaoException("Campo Nome é obrigatório.");
        } else if (cpf.isEmpty()) {
            throw new ValidacaoException("Campo CPF é obrigatório.");
        } else if (endereco.isEmpty()) {
            throw new ValidacaoException("Selecione um Endereço válido");
        } else if (telefone.equals("-")) {
            throw new ValidacaoException("O campo Telefone é obrigatório.");
        } else if (email.isEmpty()) {
            throw new ValidacaoException("O campo E=mail é obrigatório.");
        }
    }
}
