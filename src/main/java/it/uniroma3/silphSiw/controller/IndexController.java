package it.uniroma3.silphSiw.controller;

import it.uniroma3.silphSiw.model.PhotoManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }
    @RequestMapping("/gallery")
    public String gallery() {
        return "gallery.html";
    }
}
