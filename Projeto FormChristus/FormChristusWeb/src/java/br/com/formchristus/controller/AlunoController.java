/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.AlunoDao;
import br.com.formchristus.modelo.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class AlunoController extends ControllerGenerico<Aluno, String> implements Serializable{
    @EJB
    private AlunoDao dao;
    
    @PostConstruct
    private void setDao(){
        setDao(dao);
    }

    public List<Aluno> listarNome(String valorBusca) {
        return dao.listarNome(valorBusca);
    }
    
}
