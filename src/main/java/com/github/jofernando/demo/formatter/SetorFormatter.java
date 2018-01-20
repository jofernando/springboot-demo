/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jofernando.demo.formatter;

import com.github.jofernando.demo.model.entidades.Setor;
import com.github.jofernando.demo.model.repository.Setores;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 *
 * @author fernando
 */
@Component
public class SetorFormatter implements Formatter<Setor> {

    @Autowired
    private Setores repository;

    @Override
    public String print(Setor setor, Locale locale) {
        try {
            return setor.getId().toString();
        } catch (Exception e) {
            System.out.println("Falha ao fazer conversão de objeto para string. Erro: " + e);
            return null;
        }
    }

    @Override
    public Setor parse(String string, Locale locale) throws ParseException {
        try {
            return repository.findOne(Long.valueOf(string));
        } catch (NumberFormatException e) {
            System.out.println("Falha ao fazer conversão de string para objeto. Erro: " + e);
            return null;
        }
    }

}
