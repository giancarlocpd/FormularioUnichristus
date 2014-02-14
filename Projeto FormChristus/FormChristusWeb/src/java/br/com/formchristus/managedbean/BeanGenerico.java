/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.formchristus.managedbean;

import javax.faces.context.FacesContext;

/**
 *
 *
 * @param <T>
 * @author Gilmário
 */
public abstract class BeanGenerico<T> extends BeanMenssagem {

    

    public BeanGenerico(Class classe) {
        //pegarListadeCampos(classe);
    }

    /**
     * Implemantar o metodo de novo registro
     */
    public abstract void iniciar();

    /**
     * Implemantar o metodo de salvar
     */
    public abstract void salvar();

    /**
     * Implemantar o metodo de deletar
     */
    public abstract void excluir();

    /**
     * Implemantar o metodo de listar
     */
    public abstract void listar();

    /**
     * Implemantar o metodo de selecionar
     */
    public abstract void selecionar();

    /**
     *
     * @param key
     * @return
     */
    protected T getValueSession(String key) {
        return (T) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
    }

    /**
     *
     * @param key
     */
    protected Object removeValueSession(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
    }

    /**
     *
     * @param key
     * @param value
     */
    protected void setValueSession(String key, T value) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
    }

    
}
