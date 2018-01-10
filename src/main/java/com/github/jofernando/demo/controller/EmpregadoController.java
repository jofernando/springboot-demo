/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.controller;

import com.github.jofernando.demo.model.entidades.Empregado;
import com.github.jofernando.demo.model.repository.Empregados;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fernando
 */
@Controller
public class EmpregadoController implements Serializable {

    @Autowired
    private Empregados empregados;
    private Empregado empregado;

    public EmpregadoController() {
        this.empregado = new Empregado();
    }

    public void salvarAction() {
        empregados.save(empregado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empregado salvo"));
        novoEmpregado();
    }

    public void deletarAction() {
        empregados.delete(empregado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empregado deletado"));
    }

    public void alterarAction() {
        empregados.saveAndFlush(empregado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empregado alterado"));
        novoEmpregado();
    }

    public List<Empregado> buscarTodosAction() {
        return empregados.findAll();
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public void novoEmpregado() {
        empregado = new Empregado();
    }

}
