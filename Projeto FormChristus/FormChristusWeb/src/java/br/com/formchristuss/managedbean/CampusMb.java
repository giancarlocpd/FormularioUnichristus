/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristuss.managedbean;

import br.com.formchristuus.controller.CampusController;
import br.com.formchristus.modelo.Campus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Ari
 */
@ManagedBean
@ViewScoped
public class CampusMb extends BeanGenerico<Campus> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private CampusController controller;
    private Campus campus;
    private List<Campus> listaCampus;

    public CampusMb() {
        super(Campus.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
      //  campus = new Campus();
        campus = (Campus) beanUtilitario.getRegistroDoMap("campus", new Campus());
        listaCampus = new ArrayList<>();
    }

    @Override
    public void salvar() {
        try {
            controller.salvarouAtualizar(campus);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("erro"));
            Logger.getLogger(CampusMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void selecionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public List<Campus> getListaCampus() {
        return listaCampus;
    }

    public void setListaCampus(List<Campus> listaCampus) {
        this.listaCampus = listaCampus;
    }

}
