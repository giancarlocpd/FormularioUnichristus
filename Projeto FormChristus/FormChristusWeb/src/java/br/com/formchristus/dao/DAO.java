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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

/**
 *
 * @author Ari
 */
public class DAO<T> extends DaoGenerico<T, Serializable> implements Serializable {

    @PersistenceContext(unitName = "FormChristusWebPU")
    private EntityManager em;

    public DAO(Class classe) {
        super(classe);
    }

    @Override
    public void salvar(T t) throws Exception {
        em.persist(t);
    }

    @Override
    public void excluir(T t) throws Exception {
        em.remove(t);
    }

    @Override
    public void atualizar(T t) throws Exception {
        em.merge(t);
    }

    @Override
    public T carregar(Serializable id) throws Exception {
        return em.find(getEntityClass(), id);
    }

    @Override
    public T gerenciar(Serializable id) throws Exception {
      return em.getReference(getEntityClass(), id);
    }

    @Override
    public List<T> listarTodos(String ordem) throws SQLException, PersistenceException, EJBException, Exception {
        return em.createQuery("FROM " + getEntityClass().getName() + " order by :ordem")
                .setParameter("ordem", ordem).getResultList();
    }

  

    @Override
    public List<T> listarTodos(String ordem, String campo, String valor) throws SQLException, PersistenceException, EJBException, Exception {
        return em.createQuery("SELECT a FROM " + getEntityClass().getName() + " a WHERE a." + campo + " like :valor order by a." + ordem).setParameter("valor", valor + "%").getResultList();
    }

  
    
}
