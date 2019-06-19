package it.uniroma3.silphSiw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Photo {

    @Id
    private String id;

    private String name;

    private String description;

    @ManyToOne
    private Album album;

    @ManyToOne
    private Photographer photographer;

    public Photo() {
    }

    public Photo(String id, String name, String description, Album album, Photographer photographer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.album = album;
        this.photographer = photographer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer = photographer;
    }
}
