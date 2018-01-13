/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fernando
 */
@Named
@RequestScoped
@RequestMapping(path = "/")
public class PaginaInicialController {

    @GetMapping
    public String index() {
        return "index.xhtml";
    }
}
