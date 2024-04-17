package com.riwi.primeraweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.service.CoderService;;




@Controller
/* Método para montar la vista y enviarle la lista */
@RequestMapping("/")
public class CoderController {
    @Autowired
    private CoderService objCoderService;

    @GetMapping
    public String showViewGetAll (Model objModel) {
        /* Llamo el servicio y guardo la lista de coders */
        List<Coder> list = this.objCoderService.findAll();

        System.out.println(list);
        objModel.addAttribute("coderList", list);
        
        /* Se debe retornar el nombre exacto de la vista HTML con la que va a conectar */
        return "viewCoder";
    }

    
}
