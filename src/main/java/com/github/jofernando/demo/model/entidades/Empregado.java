/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.model.entidades;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

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
        setor = new Setor();
    }

    public Empregado(String nome, String cpf, String email, BigDecimal salario, Setor setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.salario = salario;
        this.setor = setor;
    }

    @NotBlank(message = "Informe um nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(unique = true)
    @CPF(message = "CPF inválido")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(unique = true)
    @NotBlank(message = "Informe um email")
    @Email(message = "Email inválido")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "Informe um salário")
    @Range(min = 954, message = "Valor informado está abaixo do salário minimo")
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @ManyToOne
    @NotNull(message = "Informe um setor")
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
