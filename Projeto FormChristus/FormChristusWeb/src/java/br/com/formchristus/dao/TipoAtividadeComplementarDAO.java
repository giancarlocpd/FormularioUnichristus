/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import br.com.formchristus.modelo.AtividadeComplementar;
import br.com.formchristus.modelo.TipoAtividadeComplementar;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Giancarlo
 */
@Stateless
public class TipoAtividadeComplementarDAO extends DAO<TipoAtividadeComplementar> implements Serializable{
    
    public TipoAtividadeComplementarDAO() {
        super(TipoAtividadeComplementar.class);
    }
    
    public List<TipoAtividadeComplementar> listarAtividades (String nome){
        TypedQuery<TipoAtividadeComplementar> q;
        q = getEm().createQuery("SELECT t FROM TipoAtividadeComplementar t WHERE t.nome LIKE :nome", TipoAtividadeComplementar.class);
        q.setParameter("nome", "%"+nome+"%");
        return q.getResultList();
    }
}
