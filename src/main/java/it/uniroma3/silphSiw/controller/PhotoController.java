package it.uniroma3.silphSiw.controller;

import it.uniroma3.silphSiw.model.Photo;
import it.uniroma3.silphSiw.model.PhotoForm;
import it.uniroma3.silphSiw.service.AlbumService;
import it.uniroma3.silphSiw.service.FileStorageService;
import it.uniroma3.silphSiw.service.PhotoService;
import it.uniroma3.silphSiw.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PhotoController {


    @Autowired
    private PhotoService photoService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private PhotographerService photographerService;

    @Autowired
    FileStorageService fileStorageService;

    @RequestMapping("/addPhoto")
    public String addPhoto(Model model) {
        model.addAttribute("photoForm" , new PhotoForm());
        return "addPhoto.html";
    }

    @GetMapping(value = "/allPhotos")
    public String showFotografie(Model model) {
        model.addAttribute("photos", this.photoService.findAllPhotos());
        return "photos.html";
    }

    @RequestMapping(value="/uploadPhoto", method = RequestMethod.POST)
    public String uploadFoto(@Valid @ModelAttribute("photoForm") PhotoForm photoForm, Model model, BindingResult bindingResult)  {

        if(bindingResult.hasErrors())

            return "addPhoto.html";

        else {

            String fileName = fileStorageService.storeFile(photoForm.getFile());

            Photo photo = new Photo(fileName , photoForm.getName() , photoForm.getDesc() ,
                    albumService.findById(photoForm.getAlbumId()) , photographerService.findById(photoForm.getPhotographerId()));

            this.photoService.insertPhoto(photo);

            model.addAttribute("photos", this.photoService.findAllPhotos());
            return "photos.html";

        }
    }

}
