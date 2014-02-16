/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import br.com.formchristus.controller.UsuarioController;
import br.com.formchristus.enumerated.TipoPessoa;
import br.com.formchristus.modelo.Usuario;
import java.io.Serializable;
import java.nio.channels.SeekableByteChannel;
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
public class UsuarioMb extends BeanGenerico<Usuario> implements Serializable {

    @Inject
    private BeanUtilitario beanUtilitario;
    @EJB
    private UsuarioController controller;
    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    private TipoPessoa tipoPessoa;

    public UsuarioMb() {
        super(Usuario.class);
    }

    @PostConstruct
    @Override
    public void iniciar() {
        usuario = (Usuario) beanUtilitario.getRegistroDoMap("usuario", new Usuario());
        if (usuario.getLogin() != null) {
            tipoPessoa = usuario.getTipoPessoa();
        }
        listaUsuarios = new ArrayList<>();
        tipoPessoa = TipoPessoa.COORDENADOR;
    }

    @Override
    public void salvar() {
        try {
            usuario.setTipoPessoa(tipoPessoa);
            controller.salvarouAtualizar(usuario);
            BeanMenssagem.addMenssagemInfo(beanUtilitario.getMsg("cadastro"));
            iniciar();
        } catch (Exception ex) {
            BeanMenssagem.addMenssagemErro(beanUtilitario.getMsg("erro"));
            Logger.getLogger(UsuarioMb.class.getName()).log(Level.SEVERE, null, ex);
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

    public TipoPessoa[] tiposPessoa() {
        return TipoPessoa.values();
    }

    public boolean renderPessoaAluno() {
        return tipoPessoa.equals(TipoPessoa.ALUNO);
    }

    public boolean renderPessoaProfessor() {
        return tipoPessoa.equals(TipoPessoa.PROFESSOR);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

}
