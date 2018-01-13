/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.controller;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author fernando
 */
@Named
@ViewScoped
public class RenderedController implements Serializable {

    private boolean ehListagem;
    private boolean ehCadastro;
    private boolean ehEdicao;

    public RenderedController() {
        ehListagem = true;
    }

    public void listar() {
        ehListagem = true;
        ehCadastro = false;
        ehEdicao = false;
    }

    public void cadastrar() {
        ehListagem = false;
        ehCadastro = true;
        ehEdicao = false;
    }

    public void editar() {
        ehListagem = false;
        ehCadastro = false;
        ehEdicao = true;
    }

    public boolean isEhListagem() {
        return ehListagem;
    }

    public void setEhListagem(boolean ehListagem) {
        this.ehListagem = ehListagem;
    }

    public boolean isEhCadastro() {
        return ehCadastro;
    }

    public void setEhCadastro(boolean ehCadastro) {
        this.ehCadastro = ehCadastro;
    }

    public boolean isEhEdicao() {
        return ehEdicao;
    }

    public void setEhEdicao(boolean ehEdicao) {
        this.ehEdicao = ehEdicao;
    }

}
