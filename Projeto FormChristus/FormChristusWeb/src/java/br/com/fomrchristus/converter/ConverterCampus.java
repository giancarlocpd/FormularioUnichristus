/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fomrchristus.converter;

import br.com.formchristus.controller.CampusController;
import br.com.formchristus.modelo.Campus;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 * Classe de convesor do Projeto guardião em 22/03/2013
 *
 * @author Ari
 */
@Named
public class ConverterCampus implements Converter {

    @EJB
    private CampusController dao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            if (!"".equals(string)) {
                Integer id = Integer.decode(string);
                Campus m = (Campus) dao.carregar(id);
                return m;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        Campus s = (Campus) o;
        if (s.getId() != null) {
            return s.getId().toString();
        }
        return null;

    }
}
