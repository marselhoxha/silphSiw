package it.uniroma3.silphSiw.service;

import it.uniroma3.silphSiw.model.Photo;
import it.uniroma3.silphSiw.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Transactional
    public Photo insertPhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    @Transactional
    public List<Photo> findAllPhotos(){
        return (List<Photo>) photoRepository.findAll();
    }
}
