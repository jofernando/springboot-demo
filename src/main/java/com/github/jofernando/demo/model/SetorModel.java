/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.model;

import com.github.jofernando.demo.model.entidades.Setor;
import com.github.jofernando.demo.model.repository.Setores;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class SetorModel {

    @Autowired
    Setores setores;

    public void salvar(Setor setor) throws Exception {
        if (setor == null) {
            throw new Exception("Setor não pode ser nulo");
        }
        setores.save(setor);
    }

    public void deletar(Setor setor) throws Exception {
        if (setor == null) {
            throw new Exception("Setor não pode ser nulo");
        }
        setores.delete(setor);
    }

    public void alterar(Setor setor) throws Exception {
        if (setor == null) {
            throw new Exception("Setor não pode ser nulo");
        }
        setores.saveAndFlush(setor);
    }

    public List<Setor> buscarTodos() {
        return setores.findAll();
    }

}
