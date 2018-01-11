/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.model;

import com.github.jofernando.demo.model.entidades.Empregado;
import com.github.jofernando.demo.model.repository.Empregados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class EmpregadoModel {

    @Autowired
    private Empregados empregados;

    public void salvar(Empregado empregado) throws Exception {
        if (empregado == null) {
            throw new Exception("Empregado não pode ser nulo");
        } else if (empregados.findByCpf(empregado.getCpf()) != null) {
            throw new Exception("CPF já cadastrado");
        } else if (empregados.findByEmail(empregado.getEmail()) != null) {
            throw new Exception("Email já cadastrado");
        }
        empregados.save(empregado);
    }

    public void deletar(Empregado empregado) throws Exception {
        if (empregado == null) {
            throw new Exception("Empregado não pode ser nulo");
        }
        empregados.delete(empregado);
    }

    public void alterar(Empregado empregado) throws Exception {
        if (empregado == null) {
            throw new Exception("Empregado não pode ser nulo");
        }
        empregados.saveAndFlush(empregado);
    }

    public List<Empregado> buscarTodos() {
        return empregados.findAll();
    }

}
