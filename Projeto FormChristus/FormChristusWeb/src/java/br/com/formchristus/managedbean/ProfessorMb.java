/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.AlunoController;
import br.com.formchristus.controller.ProfessorController;
import br.com.formchristus.controller.UsuarioController;
import br.com.formchristus.enumerated.Sexo;
import br.com.formchristus.enumerated.TipoPessoa;
import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.Curso;
import br.com.formchristus.modelo.Pessoa;
import br.com.formchristus.modelo.Professor;
import br.com.formchristus.modelo.Usuario;
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
 * @author Giancarlo
 */
@ManagedBean
@ViewScoped
public class ProfessorMb extends BeanGenerico<Professor> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private ProfessorController controller;
    @EJB
    private UsuarioController usuarioController;
    private Professor professor;
    private Pessoa pessoa;
    private Sexo sexo;
    private boolean ativo;
    private boolean renderMatricula;
    private Usuario usuario;
    private List<Professor> listaProfessor;

    public ProfessorMb() {
        super(Professor.class);
    }

    @Override
    @PostConstruct
    public void iniciar() {
        professor = (Professor) beanUtilitario.getRegistroDoMap("professor", new Professor());
        if (professor.getMatrciula() != null) {
            pessoa = professor.getPessoa();
            sexo = pessoa.getSexo();
            ativo = pessoa.isAtivo();
            renderMatricula = true;
        } else {
            pessoa = new Pessoa();
            renderMatricula = false;

        }
        usuario = new Usuario();
        listaProfessor = new ArrayList<>();

    }

    @Override
    public void salvar() {
        try {
            pessoa.setAtivo(ativo);
            pessoa.setSexo(sexo);
            professor.setPessoa(pessoa);
            controller.salvarouAtualizar(professor);
            //não sei como ficaria o parametro curso para o professor, já que ele contem um lista de cursos. Só se criar um metodo registarUsuario sem o prametro curso
            usuarioController.registrarUsuario(professor.getMatrciula(), TipoPessoa.PROFESSOR, (Curso) professor.getCurso());
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemErro(beanUtilitario.getMsg("erro"));
            Logger.getLogger(ProfessorMb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listarNome() {
        listaProfessor = controller.listarNome(getValorBusca());
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

    public BeanUtilitario getBeanUtilitario() {
        return beanUtilitario;
    }

    public void setBeanUtilitario(BeanUtilitario beanUtilitario) {
        this.beanUtilitario = beanUtilitario;
    }

    public ProfessorController getController() {
        return controller;
    }

    public void setController(ProfessorController controller) {
        this.controller = controller;
    }

    public UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isRenderMatricula() {
        return renderMatricula;
    }

    public void setRenderMatricula(boolean renderMatricula) {
        this.renderMatricula = renderMatricula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Professor> getListaProfessor() {
        return listaProfessor;
    }

    public void setListaProfessor(List<Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }

}
