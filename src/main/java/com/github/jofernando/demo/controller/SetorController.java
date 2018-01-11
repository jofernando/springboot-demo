/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.controller;

import com.github.jofernando.demo.model.SetorModel;
import com.github.jofernando.demo.model.entidades.Setor;
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
public class SetorController implements Serializable {

    @Autowired
    private SetorModel model;
    private Setor setor;

    public SetorController() {
        this.setor = new Setor();
    }

    public void salvarAction() {
        try {
            model.salvar(setor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Setor salvo"));
            novoSetor();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public void deletarAction() {
        try {
            model.deletar(setor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Setor deletado"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public void alterarAction() {
        try {
            model.alterar(setor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Setor alterado"));
            novoSetor();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
        }
    }

    public List<Setor> buscarTodosAction() {
        return model.buscarTodos();
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public void novoSetor() {
        setor = new Setor();
    }
}
