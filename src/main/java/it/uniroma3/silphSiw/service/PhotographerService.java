package it.uniroma3.silphSiw.service;

import it.uniroma3.silphSiw.model.Photo;
import it.uniroma3.silphSiw.model.Photographer;
import it.uniroma3.silphSiw.repository.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhotographerService {

    @Autowired
    private PhotographerRepository photographerRepository;

    @Transactional
    public Photographer insertPhotographer(Photographer photographer) {
        return photographerRepository.save(photographer);
    }

    @Transactional
    public List<Photo> getPhotoByPhotoghraper(Long id) {
        return (List<Photo>)photographerRepository.findById(id).get().getPhotoList();
    }

    @Transactional
    public List<Photographer> findAllPhotographers(){
        return (List<Photographer>) photographerRepository.findAll();
    }

    public Photographer findById(Long id) {
        return photographerRepository.findById(id).get();
    }
}
