package it.uniroma3.silphSiw.controller;

import it.uniroma3.silphSiw.model.Album;
import it.uniroma3.silphSiw.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/addAlbum")
    public String addAlbum(Model model) {
        model.addAttribute("album" , new Album());
        return "addAlbum.html";
    }

    @RequestMapping(value = "/findAllAlbum")
    public String showAlbum(Model model) {
        model.addAttribute("albums", this.albumService.findAllAlbums());
        return "album.html";
    }

    @GetMapping(value="/album/{id}")
    public String showPhotoAlbum(@PathVariable("id") Long id , Model model) {

        model.addAttribute("photos" , albumService.getPhotoByAlbum(id));
        model.addAttribute("name" , albumService.findById(id).getName());
        model.addAttribute("desc" , albumService.findById(id).getDescription());

        return "photoAlbum.html";

    }

    @RequestMapping(value="/addNewAlbum", method = RequestMethod.POST)
    public String newAlbum(@Valid @ModelAttribute("album") Album album, Model model, BindingResult bindingResult) {

        this.albumService.insertAlbum(album);

        model.addAttribute("albums", this.albumService.findAllAlbums());
        return "album.html";

    }
}
