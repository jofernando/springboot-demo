/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.validator;

import com.github.jofernando.demo.model.entidades.Setor;
import com.github.jofernando.demo.model.repository.Setores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author fernando
 */
@Component
@Qualifier(value = "setorValidator")
public class SetorValidator implements Validator {

    @Autowired
    private Setores setores;

    @Override
    public boolean supports(Class<?> type) {
        return Setor.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Setor setor = (Setor) o;
        if (setores.findByNome(setor.getNome()) != null) {
            errors.rejectValue("nome", "invalid", "Setor com este nome já cadastrado");
        }
    }

}
