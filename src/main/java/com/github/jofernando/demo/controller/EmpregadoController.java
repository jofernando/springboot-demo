/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.controller;

import com.github.jofernando.demo.model.EmpregadoModel;
import com.github.jofernando.demo.model.entidades.Empregado;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fernando
 */
@Named
@ViewScoped
public class EmpregadoController implements Serializable {

    @Autowired
    private EmpregadoModel model;
    private Empregado empregado;

    public EmpregadoController() {
        this.empregado = new Empregado();
    }

    public void salvarAction() {
        try {
            model.salvar(empregado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empregado salvo"));
            novoEmpregado();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public void deletarAction() {
        try {
            model.deletar(empregado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empregado deletado"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public void alterarAction() {
        try {
            model.alterar(empregado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empregado alterado"));
            novoEmpregado();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public List<Empregado> buscarTodosAction() {
        return model.buscarTodos();
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
