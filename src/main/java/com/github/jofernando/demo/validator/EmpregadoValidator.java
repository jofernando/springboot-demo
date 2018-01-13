/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.validator;

import com.github.jofernando.demo.model.repository.Empregados;
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
public class EmpregadoValidator implements Serializable {

    @Autowired
    private Empregados empregados;

    public void cpfDuplicadoValidator(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if (empregados.findByCpf((String) o) != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF já cadastrado", null));
        }
    }

    public void emailDuplicadoValidator(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        if (empregados.findByEmail((String) o) != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email já cadastrado", null));
        }
    }
}
