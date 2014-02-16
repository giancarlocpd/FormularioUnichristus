/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.AlunoController;
import br.com.formchristus.enumerated.Sexo;
import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.AtividadeComplementar;
import br.com.formchristus.modelo.Pessoa;
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
public class AlunoMb extends BeanGenerico<Aluno> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private AlunoController controller;
    private Aluno aluno;
    private List<Aluno> listaAlunos;
    private Pessoa pessoa;
    private Sexo sexo;
    private boolean  ativo;
    private boolean renderMatricula;

    public AlunoMb() {
        super(Aluno.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        aluno = (Aluno) beanUtilitario.getRegistroDoMap("aluno", new Aluno());
        if (aluno.getMatricula() != null) {
            pessoa = aluno.getPessoa();
            sexo = pessoa.getSexo();
            ativo = pessoa.isAtivo();
            renderMatricula = true;
        } else {
            pessoa = new Pessoa();
            renderMatricula = false;
            
        }
        listaAlunos = new ArrayList<>();

    }

    @Override
    public void salvar() {
        try {
            pessoa.setAtivo(ativo);
            pessoa.setSexo(sexo);
            aluno.setPessoa(pessoa);
            controller.salvarouAtualizar(aluno);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemErro(beanUtilitario.getMsg("erro"));
            Logger.getLogger(AlunoMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listarNome(){
        listaAlunos = controller.listarNome(getValorBusca());
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

    public Sexo[] sexos(){
        return  Sexo.values();
    }
     
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
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

}
