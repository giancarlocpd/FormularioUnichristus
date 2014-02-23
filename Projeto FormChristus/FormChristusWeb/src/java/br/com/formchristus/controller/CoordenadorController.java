/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.CoordenadorDAO;
import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.Coordenador;
import br.com.formchristus.modelo.Curso;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Giancarlo
 */
@Stateless
public class CoordenadorController extends ControllerGenerico<Coordenador, String> implements Serializable{
    @EJB
    private CoordenadorDAO dao;
    @PostConstruct
    private void setDAO(){
        setDao(dao);
    }
    
    public List<Coordenador> listarNome(String valorBusca) {
        return dao.listarNome(valorBusca);
    }
    
    
}
