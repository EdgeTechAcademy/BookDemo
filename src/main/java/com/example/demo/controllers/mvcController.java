package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mvcController {
    @RequestMapping(value = "/mvc")
    public String mvcCreate(Model model){
        model.addAttribute("reverseUrl", "com.example.demo");
        model.addAttribute("entity", "your class goes here");
        model.addAttribute("findBy", true);

        return "Godzilla";
    }

    @RequestMapping(value = "/mvc/create", method = RequestMethod.POST)
    public String save(@RequestParam String reverseUrl, String entity, String findBy, Model model){
        model.addAttribute("reverseUrl", reverseUrl);
        model.addAttribute("entity", entity);
        model.addAttribute("findBy", findBy);

        Godzilla.buildMVC(reverseUrl, entity, findBy == null ? false : findBy.equals("true"));
        System.out.println("and we are done");
        return "redirect:/books/";              //  go to the book listing home page
    }
}
