package ru.mobydrake.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/{name}")
    public String hello(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        return "index";
    }


}
