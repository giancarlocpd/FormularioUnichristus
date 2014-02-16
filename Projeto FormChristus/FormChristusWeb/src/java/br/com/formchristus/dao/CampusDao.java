/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import br.com.formchristus.modelo.Campus;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ari
 */
@Stateless
public class CampusDao extends DAO<Campus> implements Serializable{

    public CampusDao() {
        super(Campus.class);
    }

    public List<Campus> listarNome(String nome) {
        TypedQuery<Campus> q;
        q = getEm().createQuery("SELECT c FROM Campus c WHERE c.nome LIKE :nome", Campus.class);
        q.setParameter("nome", "%"+nome+"%");
        return q.getResultList();
    }
    
}
