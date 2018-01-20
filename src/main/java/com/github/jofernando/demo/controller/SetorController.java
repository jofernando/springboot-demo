/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.controller;

import com.github.jofernando.demo.model.entidades.Setor;
import com.github.jofernando.demo.model.repository.Setores;
import java.io.Serializable;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fernando
 */
@Controller
@RequestMapping("setor")
public class SetorController implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Validator setorValidator;
    private final Setores repository;

    @Autowired
    public SetorController(@Qualifier(value = "setorValidator") Validator setorValidator, Setores repository) {
        this.setorValidator = setorValidator;
        this.repository = repository;
    }

    @GetMapping
    public ModelAndView loadFormPage(Setor setor) {
        return new ModelAndView("/setor/cadastro");
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid Setor setor, BindingResult bindingResult, RedirectAttributes attributes) {
        setorValidator.validate(setor, bindingResult);
        if (bindingResult.hasErrors()) {
            return loadFormPage(setor);
        }
        repository.save(setor);
        attributes.addFlashAttribute("sucesso", "Setor salvo com sucesso!");
        return new ModelAndView("redirect:/setor");
    }

    @DeleteMapping("/{id}")
    public ModelAndView deletar(@PathVariable Long id, RedirectAttributes attributes) {
        repository.delete(id);
        attributes.addFlashAttribute("sucesso", "Setor deletado com sucesso!");
        ModelAndView mav = new ModelAndView("redirect:/setor/list");
        mav.addObject("setores", repository.findAll());
        return mav;
    }

    @GetMapping("/list")
    public ModelAndView listar() {
        ModelAndView mav = new ModelAndView("/setor/listagem");
        mav.addObject("setores", repository.findAll());
        return mav;
    }

}
