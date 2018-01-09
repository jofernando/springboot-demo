/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.model.entidades;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author fernando
 */
@Entity
public class Empregado extends Entidade {

    private String nome;
    private String cpf;
    private String email;
    private BigDecimal salario;
    private Setor setor;

    public Empregado() {
    }

    public Empregado(String nome, String cpf, String email, BigDecimal salario, Setor setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.salario = salario;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @ManyToOne
    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Empregado{" + "nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", salario=" + salario + ", setor=" + setor + '}';
    }

}
