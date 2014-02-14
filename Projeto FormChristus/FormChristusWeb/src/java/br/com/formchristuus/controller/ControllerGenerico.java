/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristuus.controller;

import br.com.formchristus.dao.DAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.PersistenceException;

/**
 *
 * @author Ari
 */
public abstract class ControllerGenerico<T, PK extends Serializable> implements Serializable {

    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public void salvar(T t) throws  Exception {
        dao.salvar(t);
    }

    /**
     *
     * @param t
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public void salvarouAtualizar(T t) throws  Exception {
        dao.atualizar(t);
    }

    /**
     *
     * @param t
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public void excluir(T t) throws Exception {
        dao.excluir(t);
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public Object carregar(PK id) throws  Exception {
        return dao.carregar(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public Object gerenciar(PK id) throws  Exception {
        return dao.gerenciar(id);
    }

    /**
     *
     * @param ordem
     * @param campo
     * @param valor
     * @return
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public List<T> listarTodos(String ordem, String campo, String valor) throws  Exception {
        return dao.listarTodos(ordem, campo, valor);
    }

    /**
     *
     * @return @throws SQLException
     * @throws SQLException
     * @throws PersistenceException
     * @throws EJBException
     * @throws Exception
     */
    public List<T> listarTodos(String ordem) throws  Exception {
        return dao.listarTodos(ordem);
    }

    public void atualizar(T t) throws  Exception {
        dao.atualizar(t);
    }
}
