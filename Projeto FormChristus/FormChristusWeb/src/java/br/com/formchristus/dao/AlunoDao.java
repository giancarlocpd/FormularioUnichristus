/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.dao;

import br.com.formchristus.modelo.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ari
 */
@Stateless
public class AlunoDao extends DAO<Aluno> implements Serializable{
    public AlunoDao(){
        super(Aluno.class);
    }

  public List<Aluno> listarNome(String nome) {
        TypedQuery<Aluno> q;
        q = getEm().createQuery("SELECT a FROM Aluno a WHERE a.pessoa.nome LIKE :nome", Aluno.class);
        q.setParameter("nome", "%"+nome+"%");
        return q.getResultList();
    }
}
