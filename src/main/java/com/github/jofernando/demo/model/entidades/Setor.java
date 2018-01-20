/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author fernando
 */
@Entity
public class Setor extends Entidade {

    private static final long serialVersionUID = 1L;
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "Informe um nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Setor{" + "nome=" + nome + '}';
    }

}
