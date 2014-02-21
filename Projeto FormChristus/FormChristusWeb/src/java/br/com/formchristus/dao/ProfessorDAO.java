/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.dao;

import br.com.formchristus.modelo.Curso;
import br.com.formchristus.modelo.Professor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Giancarlo
 */
@Stateless
public class ProfessorDAO extends DAO<Professor> implements Serializable {

    public ProfessorDAO() {
        super(ProfessorDAO.class);
    }

    public List<Professor> listarNome(String nome) {
        TypedQuery<Professor> q;
        q = getEm().createQuery("SELECT p FROM Professor p WHERE p.pessoa.nome LIKE :nome", Professor.class);
        q.setParameter("nome", "%"+nome+"%");
        return q.getResultList();

    }
    
    public List<Curso> listarCurso() {
        String nome = null;
        TypedQuery<Curso> q;
        q = getEm().createQuery("SELECT c FROM Curso c WHERE c.nome LIKE :nome", Curso.class);
        q.setParameter("nome", "%"+nome+"%");
        return q.getResultList();
    }

}
