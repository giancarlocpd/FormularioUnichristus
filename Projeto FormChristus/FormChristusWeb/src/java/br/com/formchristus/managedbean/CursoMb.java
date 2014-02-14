/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formChristus.controller.CursoController;
import br.com.formchristus.enumerated.Turno;
import br.com.formchristus.modelo.Curso;
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
public class CursoMb extends BeanGenerico<Curso> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private CursoController controller;
    private Curso curso;
    private List<Curso> listaCursos;

    public CursoMb() {
        super(Curso.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        curso = (Curso) beanUtilitario.getRegistroDoMap("curso", new Curso());
        listaCursos = new ArrayList<>();
    }

    @Override
    public void salvar() {
        try {
            controller.salvarouAtualizar(curso);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("erro"));
            Logger.getLogger(CursoMb.class.getName()).log(Level.SEVERE, null, ex);
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
    
    public Turno[] turnos(){
        return Turno.values();
    }

}
