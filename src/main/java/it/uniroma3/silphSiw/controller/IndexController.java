package it.uniroma3.silphSiw.controller;

import it.uniroma3.silphSiw.model.PhotoManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String addManager(Model model) {
        model.addAttribute("manager" , new PhotoManager());
        return "index.html";
    }
}
