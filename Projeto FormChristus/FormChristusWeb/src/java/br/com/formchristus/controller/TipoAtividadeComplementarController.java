/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.TipoAtividadeComplementarDAO;
import br.com.formchristus.modelo.AtividadeComplementar;
import br.com.formchristus.modelo.TipoAtividadeComplementar;
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
public class TipoAtividadeComplementarController extends ControllerGenerico<TipoAtividadeComplementar, Integer> implements Serializable{
    @EJB
    private TipoAtividadeComplementarDAO dao;
    
    @PostConstruct
    private void setDao(){
        setDao(dao);
    }
    
    public List<TipoAtividadeComplementar> listarNome(String nome) {
        return dao.listarAtividades(nome);
    }
    
}
