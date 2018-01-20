/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.controller;

import com.github.jofernando.demo.model.entidades.Empregado;
import com.github.jofernando.demo.model.repository.Empregados;
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
@RequestMapping("empregado")
public class EmpregadoController implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Validator empregadoValidator;
    private final Empregados empregadosRepository;
    private final Setores setoresRepository;

    @Autowired
    public EmpregadoController(@Qualifier(value = "empregadoValidator") Validator empregadoValidator, Empregados empregadosRepository, Setores setoresRepository) {
        this.empregadoValidator = empregadoValidator;
        this.empregadosRepository = empregadosRepository;
        this.setoresRepository = setoresRepository;
    }

    @GetMapping
    public ModelAndView loadFormPage(Empregado empregado) {
        ModelAndView mav = new ModelAndView("/empregado/cadastro");
        mav.addObject("setores", setoresRepository.findAll());
        return mav;
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid Empregado empregado, BindingResult bindingResult, RedirectAttributes attributes) {
        empregadoValidator.validate(empregado, bindingResult);
        if (bindingResult.hasErrors()) {
            return loadFormPage(empregado);
        }
        empregadosRepository.save(empregado);
        attributes.addFlashAttribute("mensagem", "Empregado salvo com sucesso!");
        return new ModelAndView("redirect:/empregado");
    }

    @GetMapping("/{id}")
    public ModelAndView visualizar(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("/empregado/visualizacao");
        mav.addObject("empregado", empregadosRepository.findOne(id));
        return mav;
    }

    @DeleteMapping("/{id}")
    public ModelAndView deletar(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            empregadosRepository.delete(id);
            attributes.addFlashAttribute("mensagem", "Empregado deletado com sucesso!");
            return new ModelAndView("redirect:/empregado/list");
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagem", e);
            System.out.println("Falha ao deletar empregado. Erro: " + e);
            return new ModelAndView("redirect:/empregado/list");
        }
    }

    @GetMapping("/list")
    public ModelAndView listar() {
        ModelAndView mav = new ModelAndView("/empregado/listagem");
        mav.addObject("empregados", empregadosRepository.findAll());
        return mav;
    }

}
