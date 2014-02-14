/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.PersistenceException;

/**
 *
 * @author Ari
 */
public abstract class DaoGenerico<T,PK extends Serializable>  {

    
    private Class<T> entityClass;

    public DaoGenerico(Class classe){
        this.entityClass = classe;
    }
    
     public abstract void salvar(T t) throws Exception;

    public abstract void excluir(T t) throws  Exception;

    public abstract void atualizar(T t) throws   Exception;

    public abstract T carregar(PK id) throws  Exception;

    public abstract List<T> listarTodos(String ordem) throws Exception;

    public abstract List<T> listarTodos(String ordem, String campo, String valor) throws  Exception;

    public abstract T gerenciar(PK id) throws Exception;
    
    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    
    
}
