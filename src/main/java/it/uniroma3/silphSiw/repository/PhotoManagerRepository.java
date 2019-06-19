package it.uniroma3.silphSiw.repository;

import it.uniroma3.silphSiw.model.PhotoManager;

import org.springframework.data.repository.CrudRepository;

public interface PhotoManagerRepository extends CrudRepository<PhotoManager,Long> {

    public PhotoManager findByUsername(String username);
}
