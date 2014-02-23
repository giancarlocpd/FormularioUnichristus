/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.CoordenadorController;
import br.com.formchristus.controller.UsuarioController;
import br.com.formchristus.enumerated.Sexo;
import br.com.formchristus.enumerated.TipoPessoa;
import br.com.formchristus.modelo.Coordenador;
import br.com.formchristus.modelo.Curso;
import br.com.formchristus.modelo.Pessoa;
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
public class CoordenadorMb extends BeanGenerico<Coordenador> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private CoordenadorController controller;
    @EJB
    private UsuarioController usuarioController;
    private Coordenador coordenador;
    private Pessoa pessoa;
    private Sexo sexo;
    private boolean renderMatricula;
    private Usuario usuario;
    private List<Coordenador> listaCoordenadores;

    public CoordenadorMb() {
        super(Coordenador.class);
    }

    @Override
    @PostConstruct
    public void iniciar() {
        coordenador = (Coordenador) beanUtilitario.getRegistroDoMap("coordenador", new Coordenador());
        if (coordenador.getMatrciula() != null) {
            pessoa = coordenador.getPessoa();
            sexo = pessoa.getSexo();
            renderMatricula = true;
        } else {
            pessoa = new Pessoa();
            renderMatricula = false;

        }
        usuario = new Usuario();
        listaCoordenadores = new ArrayList<>();

    }

    @Override
    public void salvar() {
        try {
            pessoa.setSexo(sexo);
            coordenador.setPessoa(pessoa);
            controller.salvarouAtualizar(coordenador);
            usuarioController.registrarUsuario(coordenador.getMatrciula(), TipoPessoa.COORDENADOR, coordenador.getCurso());
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemErro(beanUtilitario.getMsg("erro"));
            Logger.getLogger(CoordenadorMb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listarNome() {
        listaCoordenadores = controller.listarNome(getValorBusca());
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

    public UsuarioController getUsuarioController() {
        return usuarioController;
    }

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Sexo[] sexos() {
        return Sexo.values();
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
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

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public List<Coordenador> getListaCoordenadores() {
        return listaCoordenadores;
    }

    public void setListaCoordenadores(List<Coordenador> listaCoordenadores) {
        this.listaCoordenadores = listaCoordenadores;
    }

 
}
