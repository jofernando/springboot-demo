/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.controller;

import com.github.jofernando.demo.model.entidades.Setor;
import com.github.jofernando.demo.model.repository.Setores;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fernando
 */
@Controller
public class SetorController implements Serializable {

    @Autowired
    private Setores setores;
    private Setor setor;

    public SetorController() {
        this.setor = new Setor();
    }

    public void salvarAction() {
        setores.save(setor);
    }

    public void deletarAction() {
        setores.delete(setor);
    }

    public void alterarAction() {
        setores.saveAndFlush(setor);
    }

    public List<Setor> buscarTodosAction() {
        return setores.findAll();
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
