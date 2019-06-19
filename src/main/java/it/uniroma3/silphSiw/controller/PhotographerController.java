package it.uniroma3.silphSiw.controller;

import it.uniroma3.silphSiw.model.Photographer;
import it.uniroma3.silphSiw.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PhotographerController {

    @Autowired
    private PhotographerService photographerService;

    @RequestMapping("/addPhotographer")
    public String addPhotographer(Model model) {
        model.addAttribute("photographer" , new Photographer());
        return "addPhotographer.html";
    }

    @RequestMapping(value = "/allPhotographers")
    public String showAllPhotographers(Model model) {
        model.addAttribute("photographers", this.photographerService.findAllPhotographers());
        return "photographers.html";
    }

    @RequestMapping(value="/addNewPhotographer", method = RequestMethod.POST)
    public String newPhotographer(@Valid @ModelAttribute("fotografo") Photographer photographer, Model model, BindingResult bindingResult) {

        this.photographerService.insertPhotographer(photographer);

        model.addAttribute("photographers", this.photographerService.findAllPhotographers());
        return "photographers.html";

    }

    @GetMapping(value="/photographer/{id}")
    public String showPhotographer(@PathVariable("id") Long id , Model model) {

        model.addAttribute("photos" , photographerService.getPhotoByPhotoghraper(id));
        model.addAttribute("nome" , photographerService.findById(id).getName());
        model.addAttribute("cognome" , photographerService.findById(id).getSurname());

        return "photographerPhotos.html";

    }
}
