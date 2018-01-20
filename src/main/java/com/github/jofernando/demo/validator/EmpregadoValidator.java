/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.validator;

import com.github.jofernando.demo.model.entidades.Empregado;
import com.github.jofernando.demo.model.repository.Empregados;
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
@Qualifier(value = "empregadoValidator")
public class EmpregadoValidator implements Validator {

    @Autowired
    private Empregados empregados;

    @Override
    public boolean supports(Class<?> type) {
        return Empregado.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Empregado empregado = (Empregado) o;
        if (empregados.findByCpf(empregado.getCpf()) != null) {
            errors.rejectValue("cpf", "invalid", "Empregado com este CPF já cadastrado");
        }
        if (empregados.findByEmail(empregado.getEmail()) != null) {
            errors.rejectValue("email", "invalid", "Empregado com este email já cadastrado");
        }
    }

}
