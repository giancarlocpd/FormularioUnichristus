/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.dao;

import br.com.formchristus.modelo.Coordenador;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Giancarlo
 */
@Stateless
public class CoordenadorDAO extends DAO<Coordenador> implements Serializable {

    public CoordenadorDAO() {
        super(CoordenadorDAO.class);
    }

    public List<Coordenador> listarNome(String nome) {
        TypedQuery<Coordenador> q;
        q = getEm().createQuery("SELECT c FROM Coordenador c WHERE c.pessoa.nome LIKE :nome", Coordenador.class);
        q.setParameter("nome", "%"+nome+"%");
        return q.getResultList();

    }
}
