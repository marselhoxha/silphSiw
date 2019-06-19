package it.uniroma3.silphSiw.service;

import it.uniroma3.silphSiw.model.Album;
import it.uniroma3.silphSiw.model.Photo;
import it.uniroma3.silphSiw.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Transactional
    public Album insertAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album findById(Long id) {
        return albumRepository.findById(id).get();
    }

    @Transactional
    public List<Photo> getPhotoByAlbum(Long id) {
        return (List<Photo>)albumRepository.findById(id).get().getPhotos();
    }

    @Transactional
    public List<Album> findAllAlbums(){
        return (List<Album>) albumRepository.findAll();
    }

}
