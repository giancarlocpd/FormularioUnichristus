/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.CampusDao;
import br.com.formchristus.modelo.Campus;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class CampusController extends ControllerGenerico<Campus, Integer> implements Serializable{
    
    @EJB
    private CampusDao dao;
    
    @PostConstruct
    private void setDao(){
        setDao(dao);
    }
    
}
