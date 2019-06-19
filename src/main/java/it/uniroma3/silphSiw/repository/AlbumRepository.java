package it.uniroma3.silphSiw.repository;

import it.uniroma3.silphSiw.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Long> {
}
