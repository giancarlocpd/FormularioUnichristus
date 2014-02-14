/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe do Projeto Siafi - Criado em 24/04/2013 - classe responsavel por
 * lançar menssagens personalizadas e padrões na página
 *
 * @author Gilmário
 */
public class BeanMenssagem {

    /**
     * Lança menssagem de erro na página
     *
     * @param men - Infomação da menssagem - recebe Object para poder receber
     * Exceptions
     * @param deta - Cabeçalho da menssagem
     */
    public static void addMenssagemErro(Object deta) {
        addMenssagem(FacesMessage.SEVERITY_ERROR, "Erro: ", deta);

    }

    /**
     * Lança menssagens informativas na página
     *
     * @param men - Infomação da menssagem
     * @param deta - Cabeçalho da menssagem
     */
    public static void addMenssagemInfo(Object men) {
        addMenssagem(FacesMessage.SEVERITY_INFO, "Informação: ", men);;
    }

    /**
     *
     * @param obj
     */
    public static void addMenssagemCadastroInfo(String obj) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro ", obj + " cadastrado com sucesso!"));
    }

    /**
     * Lança menssagem de aviso na página
     *
     * @param men - Informação da menssagem
     * @param deta - Cabeçalho da menssagem
     */
    public static void addMenssagemWarn(Object men) {
        addMenssagem(FacesMessage.SEVERITY_WARN, "Atenção: ", men);
    }

    /**
     * Lança menssagens fatais na página
     *
     * @param men - Informação da menssagem
     * @param deta - Cabeçalho da menssagem
     */
    public static void addMenssagemFatal(Object men) {
        addMenssagem(FacesMessage.SEVERITY_FATAL, "Erro: ", men);
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro:", "Falha ao executar o procedimendo"));

    }

    private static void addMenssagem(FacesMessage.Severity severity, String deta, Object men) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, deta, men.toString()));
    }
}
