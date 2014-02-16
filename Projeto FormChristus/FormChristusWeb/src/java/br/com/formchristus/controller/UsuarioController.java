/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.formchristus.controller;

import br.com.formchristus.dao.UsuarioDao;
import br.com.formchristus.enumerated.TipoPessoa;
import br.com.formchristus.modelo.Curso;
import br.com.formchristus.modelo.Usuario;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ari
 */
@Stateless
public class UsuarioController extends ControllerGenerico<Usuario, String> implements Serializable{
    @EJB
    private UsuarioDao dao;
    
    @PostConstruct
    private void setDao(){
        setDao(dao);
    }
    
     public  String criptografarSenha(String senha){
         MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            BigInteger hash = new BigInteger(1, digest.digest());
            senha = hash.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ex.getMessage()).log(Level.SEVERE, null, ex);
        }
        return senha;
    }
    
    
     public void alterarSenha(Usuario u, String senhaAtual, String novaSenha, String confirmeSenha) throws Exception {
      
        if (u.getSenha().equals(criptografarSenha(senhaAtual))) {
            if (novaSenha.equals(confirmeSenha)) {
                u.setSenha(novaSenha);
                dao.atualizar(u);
            }
        }

    }

    public void registrarUsuario(String matricula, TipoPessoa pessoa, Curso curso) throws Exception {
       Usuario usuario = new Usuario();
       usuario.setLogin(matricula);
       usuario.setTipoPessoa(pessoa);
       usuario.setPeriodo(new Date());
       usuario.setSenha(criptografarSenha(matricula));
       dao.salvar(usuario);
    }
    
}
