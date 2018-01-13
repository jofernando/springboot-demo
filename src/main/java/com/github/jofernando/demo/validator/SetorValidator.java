/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.validator;

import com.github.jofernando.demo.model.repository.Setores;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fernando
 */
@Named
@RequestScoped
public class SetorValidator implements Serializable {

    @Autowired
    private Setores setores;

    public void nomeDuplicadoValidator(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if (setores.findByNome((String) o) != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome já cadastrado", null));
        }
    }
}
