/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.model.repository;

import com.github.jofernando.demo.model.entidades.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author fernando
 */
public interface Empregados extends JpaRepository<Empregado, Long> {

    Empregado findByCpf(String cpf);

    Empregado findByEmail(String email);
}
