/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.converter;

import com.github.jofernando.demo.model.entidades.Setor;
import com.github.jofernando.demo.model.repository.Setores;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fernando
 */
@Component
public class SetorConverter implements Converter {

    @Autowired
    private Setores setores;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            return (Setor) setores.findOne(Long.valueOf(string));
        } catch (NumberFormatException e) {
            System.err.println("Erro: " + e);
            throw new ConverterException("Não foi possivel fazer a conversão da string para o objeto");
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        try {
            return "" + ((Setor) o).getId();
        } catch (Exception e) {
            System.err.println("Erro: " + e);
            throw new ConverterException("Não foi possivel fazer a conversão de objeto para string");
        }
    }

}
